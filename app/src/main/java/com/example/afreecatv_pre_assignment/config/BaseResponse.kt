package com.example.afreecatv_pre_assignment.config

import com.google.gson.annotations.SerializedName

abstract class BaseResponse<M> {
    abstract fun mapper() : M
}