package com.example.afreecatv_pre_assignment.src.presentation.search.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.afreecatv_pre_assignment.R

object GithubBindingAdapter {
    @BindingAdapter("imageFromUrl")
    @JvmStatic
    fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
        if(!imageUrl.isNullOrEmpty()) {
            Glide.with(view.context)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
        } else {
            view.setImageDrawable(
                ContextCompat.getDrawable(view.context,
                    R.drawable.icon_user
                ))
        }
    }
    @JvmStatic
    @BindingAdapter("set_fullName")
    fun setMan(text: TextView, fullName: String) {
        text.text = fullName
    }

    @JvmStatic
    @BindingAdapter("set_language")
    fun setWoman(text: TextView, language: String) {
        text.text = language
    }
}