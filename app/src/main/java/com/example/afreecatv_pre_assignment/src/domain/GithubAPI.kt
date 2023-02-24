package com.example.afreecatv_pre_assignment.src.domain

import com.example.afreecatv_pre_assignment.src.data.model.remote.GithubResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubAPI{
    @GET("/search/repositories")
    suspend fun search(
        @Query("q") q: String,
        @Query("per_page") per_page: Int,
        @Query("page") page: Int,
    ) : Response<GithubResponse>
}