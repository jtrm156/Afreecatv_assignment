package com.example.afreecatv_pre_assignment.src.presentation.search.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.afreecatv_pre_assignment.src.data.model.remote.Data
import com.example.afreecatv_pre_assignment.src.data.model.remote.GithubResponse
import com.example.afreecatv_pre_assignment.src.presentation.search.view.GithubListFooterView
import com.example.afreecatv_pre_assignment.src.presentation.search.view.GithubListItemView
import com.example.afreecatv_pre_assignment.util.DLog

class GithubAdapter(private val context : Context, var githubList : MutableList<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mGithubList = githubList
    private var mGithubListItemView : GithubListItemView? = null
    private var mGithubListFooterView : GithubListFooterView? = null
    private val TYPEITEM = 0
    private val TYPEFOOTERVIEW = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var holder : RecyclerView.ViewHolder? = null

        mGithubListItemView = GithubListItemView(context)
        mGithubListFooterView = GithubListFooterView(context)

        holder = if (viewType == TYPEITEM) {
            GithubListItemViewHolder(mGithubListItemView!!)
        } else {
            GithubListItemFooterViewHolder(mGithubListFooterView!!)
        }

         return holder
    }

    override fun getItemCount(): Int {
        return githubList.size+1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GithubListItemViewHolder) {
            val itemViewHolder : GithubListItemViewHolder = holder as GithubListItemViewHolder
            itemViewHolder.mItemView.setData(githubList, position)
        } else if (holder is GithubListItemFooterViewHolder) {
            val itemViewHolder : GithubListItemFooterViewHolder = holder as GithubListItemFooterViewHolder
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == githubList.size) {
            TYPEFOOTERVIEW
        } else {
            TYPEITEM
        }
    }
}