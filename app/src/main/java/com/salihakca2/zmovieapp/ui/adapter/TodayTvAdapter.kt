package com.salihakca2.zmovieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.ResultXXXXX
import com.salihakca2.zmovieapp.databinding.TodayTvItemBinding
import com.salihakca2.zmovieapp.ui.fragment.TvPageFragmentDirections
import com.squareup.picasso.Picasso

class TodayTvAdapter(var mContext: Context, var todayTvList: List<ResultXXXXX>)
    :RecyclerView.Adapter<TodayTvAdapter.CardBindingHolderTodayTv>(){

    inner class CardBindingHolderTodayTv(binding: TodayTvItemBinding): RecyclerView.ViewHolder(binding.root){
        val binding: TodayTvItemBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBindingHolderTodayTv {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: TodayTvItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.today_tv_item,parent,false)
        return CardBindingHolderTodayTv(binding)
    }

    override fun onBindViewHolder(holder: CardBindingHolderTodayTv, position: Int) {
        val todayTv = todayTvList.get(position)
        val t = holder.binding

        t.todayTvObject = todayTv

        t.textViewTodayTvRate.text = todayTv.voteAverage.toString() + "/10"
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + todayTv.posterPath).into(t.imageViewTodayTvView)

        t.imageViewTodayTvView.setOnClickListener{
            val transition = TvPageFragmentDirections.actionTvPageFragmentToDetailTodayTvFragment( todayTvObject = todayTv)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
            return todayTvList.size
    }


}