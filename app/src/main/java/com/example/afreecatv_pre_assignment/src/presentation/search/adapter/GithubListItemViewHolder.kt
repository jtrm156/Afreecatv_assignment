package com.example.afreecatv_pre_assignment.src.presentation.search.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.afreecatv_pre_assignment.src.presentation.search.view.GithubListItemView

class GithubListItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var mItemView : GithubListItemView

    init {
        this.mItemView = itemView as GithubListItemView
    }
}