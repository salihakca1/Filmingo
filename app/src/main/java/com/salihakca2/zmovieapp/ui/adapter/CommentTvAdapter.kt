package com.salihakca2.zmovieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.ResultXXXXXX
import com.salihakca2.zmovieapp.databinding.CommentTvItemBinding

class CommentTvAdapter(var mContext: Context, var commentTvList: List<ResultXXXXXX>)
    : RecyclerView.Adapter<CommentTvAdapter.CardBindingHolderCommentTv>(){

    inner class CardBindingHolderCommentTv(binding: CommentTvItemBinding) : RecyclerView.ViewHolder(binding.root){
        var binding: CommentTvItemBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBindingHolderCommentTv {

        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CommentTvItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.comment_tv_item,parent,false)
        return CardBindingHolderCommentTv(binding)
    }

    override fun onBindViewHolder(holder: CardBindingHolderCommentTv, position: Int) {
        val commentTv = commentTvList.get(position)
        val t = holder.binding

        t.commentTvObject = commentTv

        t.textViewDetailCommentTvUserName.text = "${commentTv.authorDetails.username}"
        t.textViewDetailTvComment.text = commentTv.content


    }

    override fun getItemCount(): Int {
        return commentTvList.size
    }
}