package com.salihakca2.zmovieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.ResultX
import com.salihakca2.zmovieapp.databinding.CommentsMovieBinding

class CommentAdapter(var mContext: Context, var commentList: List<ResultX>)
    :RecyclerView.Adapter<CommentAdapter.CardBindingHolder>(){

    inner class CardBindingHolder(binding: CommentsMovieBinding): RecyclerView.ViewHolder(binding.root){
        var binding: CommentsMovieBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBindingHolder {
            val layoutInflater = LayoutInflater.from(mContext)
            val binding: CommentsMovieBinding = DataBindingUtil.inflate(layoutInflater, R.layout.comments_movie,parent,false)
           return CardBindingHolder(binding)
    }

    override fun onBindViewHolder(holder: CardBindingHolder, position: Int) {
            val comment = commentList.get(position)
            val t = holder.binding

            t.movieComment = comment
            t.textViewDetailCommentUserName.text = "${comment.authorDetails.username} }"
            t.textViewDetailComment.text = comment.content

    }

    override fun getItemCount(): Int {
            return commentList.size
    }
}