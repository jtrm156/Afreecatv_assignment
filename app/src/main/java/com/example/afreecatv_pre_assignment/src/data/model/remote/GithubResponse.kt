package com.example.afreecatv_pre_assignment.src.data.model.remote

data class GithubResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
) {
    var code: Int = 0
    data class Item(
        val full_name: String,
        val language: String,
    )
    data class Owner(
        val avatar_url: String,
    )
}