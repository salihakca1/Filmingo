package com.salihakca2.zmovieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.ResultXXXXXXX
import com.salihakca2.zmovieapp.databinding.TopRatedMovieItemBinding
import com.salihakca2.zmovieapp.ui.fragment.TopRatedFragmentDirections
import com.salihakca2.zmovieapp.ui.fragment.TvPageFragmentDirections
import com.squareup.picasso.Picasso

class TopRatedMovieAdapter(var mContext: Context, var topRatedMovieList: List<ResultXXXXXXX>)
    : RecyclerView.Adapter<TopRatedMovieAdapter.CardBindingHolderTopRatedMovie>(){

    inner class CardBindingHolderTopRatedMovie(binding: TopRatedMovieItemBinding): RecyclerView.ViewHolder(binding.root){
        val binding: TopRatedMovieItemBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBindingHolderTopRatedMovie {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: TopRatedMovieItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.top_rated_movie_item,parent,false)
        return CardBindingHolderTopRatedMovie(binding)
    }

    override fun onBindViewHolder(holder: CardBindingHolderTopRatedMovie, position: Int) {
        val topRatedMovie = topRatedMovieList.get(position)
        val t = holder.binding

        t.topRateMovieObject = topRatedMovie

        t.textViewTopRateMovieRate.text = topRatedMovie.voteAverage.toString() + "/10"
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + topRatedMovie.posterPath).into(t.imageViewTopRateMovieView)
        t.imageViewTopRateMovieView.setOnClickListener{
            val transition = TopRatedFragmentDirections.actionTopRatedFragmentToDetailTopRatedMovieFragment(topRatedMovie = topRatedMovie)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
        return topRatedMovieList.size
    }
}