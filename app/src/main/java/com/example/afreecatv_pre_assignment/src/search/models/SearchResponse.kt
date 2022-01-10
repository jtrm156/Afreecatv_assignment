package com.example.afreecatv_pre_assignment.src.search.models

data class SearchResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)