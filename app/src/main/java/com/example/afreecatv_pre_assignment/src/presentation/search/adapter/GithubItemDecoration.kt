package com.example.afreecatv_pre_assignment.src.presentation.search.adapter

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GithubItemDecoration(context: Context?) : RecyclerView.ItemDecoration() {
    private var mContext : Context? = null
    private var mSpanCount : Int? = null

    init {
        mContext = context
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
    }
}