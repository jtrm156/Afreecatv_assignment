package com.example.afreecatv_pre_assignment.src.presentation.search.view

import android.content.Context
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.afreecatv_pre_assignment.databinding.ItemGithubListFooterBinding

class GithubListFooterView(context : Context) : ConstraintLayout(context) {
    private var binding : ItemGithubListFooterBinding? = null

    init {
        binding = ItemGithubListFooterBinding.inflate(LayoutInflater.from(context), this ,true)
        binding!!.root
    }

    fun setData() {

    }
}