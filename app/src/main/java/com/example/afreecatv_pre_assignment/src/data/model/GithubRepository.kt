package com.example.afreecatv_pre_assignment.src.data.model

import com.example.afreecatv_pre_assignment.config.ApplicationClass.Companion.sRetrofit
import com.example.afreecatv_pre_assignment.src.domain.GithubAPI

class GithubRepository {
    private val githubClient = sRetrofit.create(GithubAPI::class.java)

    suspend fun getGithub(q : String, perPage : Int, page : Int) = githubClient.search(q, perPage, page)
}