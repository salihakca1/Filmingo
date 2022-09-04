package com.salihakca2.zmovieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.ResultXXXXXXXX
import com.salihakca2.zmovieapp.databinding.TopRatedTvItemBinding
import com.salihakca2.zmovieapp.ui.fragment.TopRatedFragmentDirections
import com.squareup.picasso.Picasso

class TopRatedTvAdapter(var sContext: Context, var topRatedTvList: List<ResultXXXXXXXX>)
    : RecyclerView.Adapter<TopRatedTvAdapter.CardBindingHolderTopRateTv>(){
    inner class CardBindingHolderTopRateTv(binding: TopRatedTvItemBinding): RecyclerView.ViewHolder(binding.root){
        val binding: TopRatedTvItemBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBindingHolderTopRateTv {
        val layoutInflater = LayoutInflater.from(sContext)
        val binding: TopRatedTvItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.top_rated_tv_item,parent,false)
        return CardBindingHolderTopRateTv(binding)
    }

    override fun onBindViewHolder(holder: CardBindingHolderTopRateTv, position: Int) {
        val topRateTv = topRatedTvList.get(position)
        val t = holder.binding

        t.topRateTvObject = topRateTv


        t.textViewTopRateTvRate.text = topRateTv.voteAverage.toString() + "/10 "
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + topRateTv.posterPath).into(t.imageViewTopRateTvView)

        t.imageViewTopRateTvView.setOnClickListener {
            val transition = TopRatedFragmentDirections.actionTopRatedFragmentToDetailTopRatedTvFragment(topRatedTv = topRateTv)
            Navigation.findNavController(it).navigate(transition)
        }

    }

    override fun getItemCount(): Int {
        return topRatedTvList.size
    }
}