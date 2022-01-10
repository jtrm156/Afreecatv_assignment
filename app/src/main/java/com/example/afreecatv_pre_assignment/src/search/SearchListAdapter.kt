package com.example.afreecatv_pre_assignment.src.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule
import com.example.afreecatv_pre_assignment.databinding.RepositoryItemBinding
import com.example.afreecatv_pre_assignment.databinding.RepositoryLoadingBinding

@GlideModule
class MyGlide : AppGlideModule()

class SearchListAdapter(private val context: Context, var SearchArrayList: MutableList<searchlist>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Layout들과 RecyclerView를 연결시킬 Adapter(데이터를 받아오고 이를 레이아웃에 직접 연결하는 함수를 실행시키는 클래스)
    private val VIEW_TYPE_ITEM1 = 1
    private val VIEW_TYPE_ITEM2 = 2

    fun setList(searchlist: MutableList<searchlist>){
        SearchArrayList.addAll(searchlist)
        SearchArrayList.add(searchlist("","","",2))
        notifyDataSetChanged()
    }
    fun deleteLoading(){
        SearchArrayList.removeAt(SearchArrayList.lastIndex)
    }

    inner class ItemViewHolder(private val binding: RepositoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(searchlist: searchlist, num: Int, context: Context) {

            Glide.with(itemView).load(searchlist.avatar_url).diskCacheStrategy(
                DiskCacheStrategy.RESOURCE).fitCenter().into(binding.repositoryItemConst1Img1)
            binding.repositoryItemConst1Txt1.text = searchlist.full_name
            binding.repositoryItemConst1Txt2.text = searchlist.language
        }
    } //ViewHolder는 클래스 내에 View를 저장하는 변수를 만들어 그 안에 데이터를 직접 연결시킬 수 있는 클래스, 디자인 패턴

    inner class ItemViewHolder2(private val binding: RepositoryLoadingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(searchlist: searchlist, num: Int, context: Context) {
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            VIEW_TYPE_ITEM1 -> {
                val binding = RepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemViewHolder(binding)
            }

            VIEW_TYPE_ITEM2 -> {
                val binding = RepositoryLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemViewHolder2(binding)
            }

            else -> {
                val binding = RepositoryLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemViewHolder2(binding)
            }
        }
    } //화면을 최초 로딩하여 만들어진 View가 없는 경우 레이아웃을 inflate하여 viewHolder를 생성

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is SearchListAdapter.ItemViewHolder) {
            holder.bind(SearchArrayList[position], position, context)
        }
        else if(holder is SearchListAdapter.ItemViewHolder2){
            holder.bind(SearchArrayList[position], position, context)
        }
    } //layout의 view와 데이터를 연결

    override fun getItemCount(): Int {
        return SearchArrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        // 게시물과 프로그레스바 아이템뷰를 구분할 기준이 필요하다.
        return when (SearchArrayList[position].group) {
            1 -> VIEW_TYPE_ITEM1
            2 -> VIEW_TYPE_ITEM2
            else -> VIEW_TYPE_ITEM1
        }
    }
}
