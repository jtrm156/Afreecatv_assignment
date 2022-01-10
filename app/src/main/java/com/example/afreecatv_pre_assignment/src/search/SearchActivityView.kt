package com.example.afreecatv_pre_assignment.src.search

import com.example.afreecatv_pre_assignment.src.search.models.SearchResponse

interface SearchActivityView {
    fun onGet_repositories_Success(response: SearchResponse)

    fun onGet_repositories_Failure(message: String)
}