package com.example.afreecatv_pre_assignment.src.presentation.search.view

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowMetrics
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.afreecatv_pre_assignment.config.BaseActivity
import com.example.afreecatv_pre_assignment.databinding.ActivitySearchBinding
import com.example.afreecatv_pre_assignment.src.data.model.GithubRepository
import com.example.afreecatv_pre_assignment.src.data.model.remote.Data
import com.example.afreecatv_pre_assignment.src.data.model.remote.GithubResponse
import com.example.afreecatv_pre_assignment.src.presentation.search.adapter.BounceEdgeEffectFactory
import com.example.afreecatv_pre_assignment.src.presentation.search.adapter.GithubAdapter
import com.example.afreecatv_pre_assignment.src.presentation.search.adapter.GithubItemDecoration
import com.example.afreecatv_pre_assignment.src.presentation.search.viewmodel.APIViewModelFactory
import com.example.afreecatv_pre_assignment.src.presentation.search.viewmodel.GithubViewModel
import com.example.afreecatv_pre_assignment.util.DLog

class SearchActivity : BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate){
    private var githubList = mutableListOf<GithubResponse>()
    private var data = mutableListOf<Data>()

    private var page = 1

    private var vScrollOffset : Int = 0
    private var vRangeRcv : Int = 0
    private var vPagingOffset : Int = 0
    private var vScrollRange : Int = 0
    private val pRatio = 0.85f

    lateinit var viewModelFactory : APIViewModelFactory
    lateinit var githubViewModel : GithubViewModel
    lateinit var githubAdapter : GithubAdapter

    private var mHeight : Int = 0
    private var mWidth : Int = 0
    private var isLoading = false
    private var isPaging = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        initViewModel()
        initSetListener()
        setUpObserver()
    }

    private fun init() {
        mHeight = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
            windowMetrics.bounds.height()
        } else {
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display?.getRealMetrics(displayMetrics)
            displayMetrics.heightPixels
        }

        mWidth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
            windowMetrics.bounds.width()
        } else {
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display?.getRealMetrics(displayMetrics)
            displayMetrics.widthPixels
        }
        binding.searchConst1Txt1.visibility = View.VISIBLE
        val layoutManager01 = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        githubAdapter = GithubAdapter(this, data)

        binding.searchRecycle1.layoutManager = layoutManager01
        binding.searchRecycle1.adapter = githubAdapter
        binding.searchRecycle1.setHasFixedSize(true)
        binding.searchRecycle1.addItemDecoration(GithubItemDecoration(this))
        /*
        binding.searchRecycle1.apply {
            edgeEffectFactory = BounceEdgeEffectFactory(mHeight)
        }
        */
        binding.searchRecycle1.visibility = View.GONE
    }
    private fun initViewModel() {
        viewModelFactory = APIViewModelFactory(GithubRepository())
        githubViewModel = ViewModelProvider(this, viewModelFactory)[GithubViewModel::class.java]
    }

    private fun initSetListener() {
        binding.searchConst1Img1.setOnClickListener {
            showLoadingDialog(this)
            binding.searchRecycle1.visibility = View.VISIBLE
            getUserData()
            isLoading = true
        }

        binding.searchRecycle1.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                try {
                    vScrollOffset = binding.searchRecycle1.computeVerticalScrollOffset()
                    vRangeRcv = binding.searchRecycle1.computeVerticalScrollExtent()
                    vScrollRange = binding.searchRecycle1.computeVerticalScrollRange()

                    vPagingOffset = vScrollOffset % vRangeRcv

                    if (vScrollOffset < (vScrollRange - vRangeRcv) * pRatio) isLoading = false
                    if (vScrollOffset >= (vScrollRange - vRangeRcv) * pRatio && !isLoading) paging()
                } catch (e : Exception) {
                    e.printStackTrace()
                }
            }
        })
    }
    private fun setUpObserver() {
        githubViewModel.getGithubDataRepository.observe(this) {
            response ->

            if (response.code != 200) {
                Toast.makeText(this, "repository가 없습니다.",Toast.LENGTH_SHORT).show()
            } else {val list = (binding.searchRecycle1.adapter as GithubAdapter).githubList
                if (isLoading) {
                    for (i in 0 until response.items.size) {
                        list.add(Data(response.items[i].full_name, response.items[i].owner.avatarUrl, response.items[i].language))
                    }

                    githubAdapter.notifyDataSetChanged()
                } else {
                    for (i in 0 until response.items.size) {
                        list.add(Data(response.items[i].full_name, response.items[i].owner.avatarUrl, response.items[i].language))
                    }

                    githubAdapter.notifyDataSetChanged()
                }

                dismissLoadingDialog()
            }
        }
    }

    private fun getUserData() {
        githubViewModel.getGithubData(binding.searchConst1Edt1.text.toString(), 20, page)
    }

    private fun paging() {
        page += 1
        isLoading = true
        githubViewModel.getGithubData(binding.searchConst1Edt1.text.toString(), 20, page)
    }
}