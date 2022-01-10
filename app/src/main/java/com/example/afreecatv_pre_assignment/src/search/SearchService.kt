package com.example.afreecatv_pre_assignment.src.search

import com.example.afreecatv_pre_assignment.config.ApplicationClass
import com.example.afreecatv_pre_assignment.src.search.models.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchService(val view: SearchActivityView) {
    fun search(q: String,
               per_page: Int,
               page: Int){
        val searchRetrofitInterface = ApplicationClass.sRetrofit.create(SearchRetrofitInterface::class.java)
        searchRetrofitInterface.search(q,per_page,page).enqueue(object : Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response : Response<SearchResponse>) {
                view.onGet_repositories_Success((response.body() as SearchResponse))
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                view.onGet_repositories_Failure(t.message ?: "통신 오류")
            }
        })
    }
}