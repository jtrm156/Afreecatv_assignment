package com.example.afreecatv_pre_assignment.src.data.model.remote

import com.google.gson.annotations.SerializedName

data class Item (
    @SerializedName("full_name")
    val full_name: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("owner")
    val owner : Owner
)
