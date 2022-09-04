package com.salihakca2.zmovieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.Result
import com.salihakca2.zmovieapp.databinding.RecentMovieBinding
import com.salihakca2.zmovieapp.ui.fragment.HomePageFragmentDirections
import com.squareup.picasso.Picasso

class RecentAdapter(var mContext: Context, var recentList: List<Result>)
    :RecyclerView.Adapter<RecentAdapter.CardBindingHolder>(){
    inner class CardBindingHolder(binding: RecentMovieBinding): RecyclerView.ViewHolder(binding.root){
        var binding: RecentMovieBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBindingHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: RecentMovieBinding = DataBindingUtil.inflate(layoutInflater,R.layout.recent_movie,parent,false)
        return CardBindingHolder(binding)
    }

    override fun onBindViewHolder(holder: CardBindingHolder, position: Int) {
            val recentMovie =  recentList.get(position)
            val t = holder.binding

            t.textViewRecentTitle.text = recentMovie.title
            t.textViewRecentRate.text = recentMovie.voteAverage.toString() + "/ 10"
            t.textViewRecentDate.text = recentMovie.releaseDate

            t.recentObject = recentMovie
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + recentMovie.posterPath).into(t.imageViewRecentView)
            t.imageViewRecentView.setOnClickListener {
                val transition = HomePageFragmentDirections.actionHomePageFragmentToDetailPageFragment(movie = recentMovie)
                Navigation.findNavController(it).navigate(transition)
            }
    }

    override fun getItemCount(): Int {
        return recentList.size
    }
}