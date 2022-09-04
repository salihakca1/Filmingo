package com.salihakca2.zmovieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.Result
import com.salihakca2.zmovieapp.databinding.PopularMovieBinding
import com.salihakca2.zmovieapp.ui.fragment.HomePageFragmentDirections
import com.squareup.picasso.Picasso

class PopularAdapter(var mContext: Context, var popularList : List<Result>)
    : RecyclerView.Adapter<PopularAdapter.CardBindingHolder>(){

    inner class CardBindingHolder(binding: PopularMovieBinding): RecyclerView.ViewHolder(binding.root){
        var binding: PopularMovieBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBindingHolder {
            val layoutInflater = LayoutInflater.from(mContext)
            val binding: PopularMovieBinding = DataBindingUtil.inflate(layoutInflater, R.layout.popular_movie, parent,false)
            return CardBindingHolder(binding)
    }

    override fun getItemCount(): Int {
            return popularList.size
    }

    override fun onBindViewHolder(holder: CardBindingHolder, position: Int) {
        val popularMovie = popularList.get(position)

        val t = holder.binding
        t.popularObject = popularMovie
        t.textViewPopularTitle.text = popularMovie.title
        t.textViewPopularDate.text = popularMovie.releaseDate
        t.textViewPopularRate.text = popularMovie.voteAverage.toString() + "/10"

        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + popularMovie.posterPath).into(t.imageViewPopularView)
        t.imageViewPopularView.setOnClickListener {
            val transition = HomePageFragmentDirections.actionHomePageFragmentToDetailPageFragment(movie = popularMovie)
            Navigation.findNavController(it).navigate(transition)
        }

    }

}