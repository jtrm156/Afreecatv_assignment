package com.example.afreecatv_pre_assignment.src.data.model

import com.example.afreecatv_pre_assignment.config.BaseResponse
import com.example.afreecatv_pre_assignment.src.data.model.remote.GithubResponse
import com.google.gson.annotations.SerializedName

class ResGetGithubData {
    data class Response(
        @SerializedName("full_name")
        val incomplete_results: Boolean,
        @SerializedName("avatar_url")
        val items: List<GithubResponse.Item>,
        @SerializedName("language")
        val total_count: Int
    ) : BaseResponse<GithubResponse>() {
        override fun mapper(): GithubResponse {
            return GithubResponse(incomplete_results = incomplete_results, items = items, total_count = total_count)
        }
    }
}