package com.salihakca2.zmovieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.ResultXXXX
import com.salihakca2.zmovieapp.databinding.PopulerTvItemBinding
import com.salihakca2.zmovieapp.ui.fragment.HomePageFragmentDirections
import com.salihakca2.zmovieapp.ui.fragment.TvPageFragmentDirections
import com.squareup.picasso.Picasso

class PopularTvAdapter (var mContext: Context, var popularTvList: List<ResultXXXX>)
    :RecyclerView.Adapter<PopularTvAdapter.CardBindingHolderPopularTv>(){
    inner class CardBindingHolderPopularTv(binding: PopulerTvItemBinding): RecyclerView.ViewHolder(binding.root){
        val binding: PopulerTvItemBinding
        init {
            this.binding = binding
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBindingHolderPopularTv {
            val layoutInflater = LayoutInflater.from(mContext)
            val binding: PopulerTvItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.populer_tv_item,parent,false)
            return CardBindingHolderPopularTv(binding)
    }

    override fun onBindViewHolder(holder: CardBindingHolderPopularTv, position: Int) {
        val popularTv = popularTvList.get(position)

        val t = holder.binding
        t.popularTvObject = popularTv
        t.textViewPopularTvRate.text = popularTv.voteAverage.toString() + "/10 "
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + popularTv.posterPath).into(t.imageViewPopularTvView)

        t.imageViewPopularTvView.setOnClickListener {
            val transition = TvPageFragmentDirections.actionTvPageFragmentToTvDetailFragment(popularTvObject = popularTv)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
            return popularTvList.size
    }
}