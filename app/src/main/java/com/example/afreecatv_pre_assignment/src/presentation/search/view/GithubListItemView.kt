package com.example.afreecatv_pre_assignment.src.presentation.search.view

import android.content.Context
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.afreecatv_pre_assignment.R
import com.example.afreecatv_pre_assignment.databinding.ItemGithubListBinding
import com.example.afreecatv_pre_assignment.src.data.model.remote.GithubResponse
import com.example.afreecatv_pre_assignment.util.DLog

class GithubListItemView(context : Context) : ConstraintLayout(context) {
    private var binding : ItemGithubListBinding? = null

    init {
        binding = ItemGithubListBinding.inflate(LayoutInflater.from(context), this ,true)
        binding!!.root
    }

    fun setData(githubList : MutableList<GithubResponse>, position : Int) {
        binding!!.repositoryItemConst1Txt1.text = githubList[position].items[position].full_name
        binding!!.repositoryItemConst1Txt2.text = githubList[position].items[position].language

        DLog.e("12345",""+githubList[position].items[position].owner.avatarUrl)

        Glide.with(this)
            .load(githubList[position].items[position].owner.avatarUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.icon_user)
            .fallback(R.drawable.icon_user)
            .placeholder(R.drawable.icon_user)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding!!.repositoryItemConst1Img1)
    }
}