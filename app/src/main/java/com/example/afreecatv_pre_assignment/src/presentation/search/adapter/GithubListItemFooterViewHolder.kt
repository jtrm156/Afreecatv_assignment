package com.example.afreecatv_pre_assignment.src.presentation.search.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.afreecatv_pre_assignment.src.presentation.search.view.GithubListFooterView

class GithubListItemFooterViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var mItemView : GithubListFooterView

    init {
        this.mItemView = itemView as GithubListFooterView
    }
}