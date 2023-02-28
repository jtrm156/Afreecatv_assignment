package com.example.afreecatv_pre_assignment.src.data.model.remote

import com.google.gson.annotations.SerializedName

data class GithubResponse(
    @SerializedName("incomplete_results")
    val incomplete_results: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val total_count: Int,
) {
    var code: Int = 0
}

