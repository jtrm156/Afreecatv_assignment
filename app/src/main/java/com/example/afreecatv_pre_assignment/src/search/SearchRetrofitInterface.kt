package com.example.afreecatv_pre_assignment.src.search

import com.example.afreecatv_pre_assignment.src.search.models.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRetrofitInterface {
    @GET("/search/repositories")
    fun search(
        @Query("q") q: String,
        @Query("per_page") per_page: Int,
        @Query("page") page: Int,
    ) : Call<SearchResponse>
}