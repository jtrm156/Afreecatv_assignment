package com.example.afreecatv_pre_assignment.src.presentation.search.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.afreecatv_pre_assignment.config.BaseActivity
import com.example.afreecatv_pre_assignment.databinding.ActivitySearchBinding
import com.example.afreecatv_pre_assignment.src.data.model.GithubRepository
import com.example.afreecatv_pre_assignment.src.data.model.remote.GithubResponse
import com.example.afreecatv_pre_assignment.src.presentation.search.adapter.GithubAdapter
import com.example.afreecatv_pre_assignment.src.presentation.search.adapter.GithubItemDecoration
import com.example.afreecatv_pre_assignment.src.presentation.search.viewmodel.APIViewModelFactory
import com.example.afreecatv_pre_assignment.src.presentation.search.viewmodel.GithubViewModel
import com.example.afreecatv_pre_assignment.util.DLog

class SearchActivity : BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate){
    private var githubList = mutableListOf<GithubResponse>()
    private var page = 1

    private var vScrollOffset : Int = 0
    private var vRangeRcv : Int = 0
    private var vPagingOffset : Int = 0
    private var vScrollRange : Int = 0
    private val pRatio = 0.8f

    lateinit var viewModelFactory : APIViewModelFactory
    lateinit var githubViewModel : GithubViewModel
    lateinit var githubAdapter : GithubAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        setUpObserver()

        getUserData()
        binding.searchConst1Img1.setOnClickListener {
            getUserData()
        }
    }

    private fun initViewModel() {
        viewModelFactory = APIViewModelFactory(GithubRepository())
        githubViewModel = ViewModelProvider(this, viewModelFactory)[GithubViewModel::class.java]
    }

    private fun setUpObserver() {
        githubViewModel.getGithubDataRepository.observe(this) {
            response ->

            if (response.code != 200) {
                Toast.makeText(this, "repository가 없습니다.",Toast.LENGTH_SHORT).show()
            } else {
                val layoutManager01 = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

                for (i in 0 .. response.items.size) {
                    githubList.add(GithubResponse(response.incomplete_results, response.items, response.total_count))
                }

                githubAdapter = GithubAdapter(this, githubList)
                binding.searchRecycle1.layoutManager = layoutManager01
                binding.searchRecycle1.adapter = githubAdapter
                binding.searchRecycle1.setHasFixedSize(true)
                binding.searchRecycle1.addItemDecoration(GithubItemDecoration(this))

                binding.searchRecycle1.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)

                        try {
                            vScrollOffset = binding.searchRecycle1.computeVerticalScrollOffset()
                            vRangeRcv = binding.searchRecycle1.computeVerticalScrollExtent()
                            vScrollRange = binding.searchRecycle1.computeVerticalScrollRange()

                            vPagingOffset = vScrollOffset % vRangeRcv

                            if (vScrollOffset >= (vScrollRange - vRangeRcv) * pRatio) paging()
                        } catch (e : Exception) {
                            e.printStackTrace()
                        }
                    }
                })
            }
        }
    }

    private fun getUserData() {
        githubViewModel.getGithubData(binding.searchConst1Edt1.text.toString(), 20 ,page)
    }

    private fun paging() {
        page += 1
    }
}