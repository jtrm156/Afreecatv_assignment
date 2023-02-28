package com.example.afreecatv_pre_assignment.src.data.model

import com.example.afreecatv_pre_assignment.config.BaseResponse
import com.example.afreecatv_pre_assignment.src.data.model.remote.GithubResponse
import com.google.gson.annotations.SerializedName
/*
class ResGetGithubData {
    data class Response(
        @SerializedName("incomplete_results")
        val incomplete_results: Boolean,
        @SerializedName("items")
        val items: List<Item>,
        @SerializedName("total_count")
        val total_count: Int
    ) : BaseResponse<GithubResponse>() {
        override fun mapper(): GithubResponse {
            return GithubResponse(incomplete_results = incomplete_results, items = items, total_count = total_count)
        }
    }
}
*/