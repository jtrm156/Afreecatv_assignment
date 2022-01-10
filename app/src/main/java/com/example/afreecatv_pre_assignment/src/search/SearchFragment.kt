package com.example.afreecatv_pre_assignment.src.search

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.afreecatv_pre_assignment.R
import com.example.afreecatv_pre_assignment.config.ApplicationClass.Companion.sSharedPreferences
import com.example.afreecatv_pre_assignment.config.BaseFragment
import com.example.afreecatv_pre_assignment.databinding.FragmentSearchBinding
import com.example.afreecatv_pre_assignment.src.search.models.SearchResponse

data class searchlist(val full_name : String, val avatar_url : String, val language : String, val group : Int)

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search), SearchActivityView{
    var searchList = mutableListOf<searchlist>()
    var page = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val q = sSharedPreferences.getString("q",null).toString()
        SearchService(this).search(q, 10, page)

        val searchlistAdapter = SearchListAdapter(activity as SearchActivity, searchList)
        binding.searchRecycle1.adapter = searchlistAdapter

        val layout = LinearLayoutManagerWrapper(activity as SearchActivity, LinearLayoutManager.VERTICAL, false)
        binding.searchRecycle1.layoutManager = layout
        binding.searchRecycle1.setHasFixedSize(true)

        binding.searchRecycle1.addOnScrollListener(object : RecyclerView.OnScrollListener(),
            SearchActivityView {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition() // 화면에 보이는 마지막 아이템의 position
                val itemTotalCount = recyclerView.adapter!!.itemCount -1 // 어댑터에 등록된 아이템의 총 개수 -1

                // 스크롤이 끝에 도달했는지 확인
                if (!binding.searchRecycle1.canScrollVertically(1) && lastVisibleItemPosition == itemTotalCount) {
                    if (page == 11) {
                        val msg = Toast.makeText(activity,"페이지 끝입니다.", Toast.LENGTH_SHORT)
                        msg.show()
                    }
                    else {
                        val handler = android.os.Handler()
                        handler.postDelayed({
                            val number = searchlistAdapter.itemCount

                            searchList.removeAt(searchList.lastIndex)
                            Log.d("scrollinng", "vertical")

                            get_Page()

                            SearchService(this).search(q, 10, page)
                            searchlistAdapter.notifyItemInserted(searchList.lastIndex + 2)
                        },1000)
                    }
                }
            }

            override fun onGet_repositories_Success(response: SearchResponse) {

                val index = response.items.size

                for (i in 0 .. index -1) {
                    var full_name = response.items[i].full_name
                    var avatar_url = response.items[i].owner.avatar_url
                    var language = response.items[i].language

                    if(language == null){
                        searchList.add(searchlist("${full_name}","${avatar_url}","No language specified",1))
                    }
                    else {
                        searchList.add(searchlist("${full_name}","${avatar_url}","${language}",1))
                    }
                }
                searchList.add(searchlist(" "," "," ",2))
            }

            override fun onGet_repositories_Failure(message: String) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onGet_repositories_Success(response: SearchResponse) {
        val index = response.items.size

        for (i in 0 .. index-1) {
            var full_name = response.items[i].full_name
            var avatar_url = response.items[i].owner.avatar_url
            var language = response.items[i].language

            if(language == null){
                searchList.add(searchlist("${full_name}","${avatar_url}","No language specified",1))
            }
            else {
                searchList.add(searchlist("${full_name}","${avatar_url}","${language}",1))
            }
        }
        searchList.add(searchlist(" "," "," ",2))
    }

    override fun onGet_repositories_Failure(message: String) {
        TODO("Not yet implemented")
    }

    fun get_Page() : Int {
        page++
        return page
    }
}

class LinearLayoutManagerWrapper: LinearLayoutManager {
    constructor(context: Context) : super(context) {} constructor(context: Context, orientation: Int, reverseLayout: Boolean) : super(context, orientation, reverseLayout) {}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {}
    override fun supportsPredictiveItemAnimations(): Boolean { return false }
}