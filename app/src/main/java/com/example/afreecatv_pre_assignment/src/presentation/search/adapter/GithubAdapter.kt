package com.example.afreecatv_pre_assignment.src.presentation.search.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.afreecatv_pre_assignment.src.data.model.remote.GithubResponse
import com.example.afreecatv_pre_assignment.src.presentation.search.view.GithubListFooterView
import com.example.afreecatv_pre_assignment.src.presentation.search.view.GithubListItemView
import com.example.afreecatv_pre_assignment.util.DLog

class GithubAdapter(private val context : Context, var githubList : MutableList<GithubResponse>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mGithubList = githubList
    private val TYPEITEM = 0
    private val TYPEFOOTERVIEW = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var holder : RecyclerView.ViewHolder? = null

        var githubListItemView : GithubListItemView = GithubListItemView(context)
        var githubListFooterView : GithubListFooterView = GithubListFooterView(context)

        if (viewType == TYPEITEM) {
            holder = GithubListItemViewHolder(githubListItemView)
        } else {
            holder = GithubListItemFooterViewHolder(githubListFooterView)
        }
         return holder!!
    }

    override fun getItemCount(): Int {
        return mGithubList.size+1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GithubListItemViewHolder && position < mGithubList.size) {
            val itemViewHolder : GithubListItemViewHolder = holder as GithubListItemViewHolder

            itemViewHolder.mItemView.setData(mGithubList, position)
        } else if (holder is GithubListItemFooterViewHolder && position == mGithubList.size) {
            val itemViewHolder : GithubListItemFooterViewHolder = holder as GithubListItemFooterViewHolder
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == mGithubList.size) {
            TYPEFOOTERVIEW
        } else {
            TYPEITEM
        }
    }
}