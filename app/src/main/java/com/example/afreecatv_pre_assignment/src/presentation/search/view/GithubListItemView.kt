package com.example.afreecatv_pre_assignment.src.presentation.search.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.afreecatv_pre_assignment.R
import com.example.afreecatv_pre_assignment.databinding.ItemGithubListBinding
import com.example.afreecatv_pre_assignment.src.data.model.remote.Data
import com.example.afreecatv_pre_assignment.src.data.model.remote.GithubResponse
import com.example.afreecatv_pre_assignment.util.DLog

class GithubListItemView(context : Context) : ConstraintLayout(context) {
    private var binding : ViewDataBinding? = null

    init {
        binding = DataBindingUtil.inflate<ItemGithubListBinding>(
            LayoutInflater.from(context),
            R.layout.item_github_list,
            this,
            true
        )

        //binding = ItemGithubListBinding.inflate(LayoutInflater.from(context), this ,true)
        binding!!.root
    }

    fun setData(githubList : MutableList<Data>, position : Int) {
        binding.model = githubList
        DLog.e("12347",""+position+"/"+githubList.size)

        /*
        binding!!.repositoryItemConst1Txt1.text = githubList[position].fullName
        binding!!.repositoryItemConst1Txt2.text = githubList[position].language

        Glide.with(this)
            .load(githubList[position].avatarUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.icon_user)
            .fallback(R.drawable.icon_user)
            .placeholder(R.drawable.icon_user)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding!!.repositoryItemConst1Img1)
         */
    }
}