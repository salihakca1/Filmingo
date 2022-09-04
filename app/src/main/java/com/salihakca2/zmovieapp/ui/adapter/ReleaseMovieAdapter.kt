package com.salihakca2.zmovieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.Result
import com.salihakca2.zmovieapp.data.entity.ResultXX
import com.salihakca2.zmovieapp.databinding.ReleaseMovieItemBinding
import com.salihakca2.zmovieapp.ui.fragment.HomePageFragmentDirections
import com.salihakca2.zmovieapp.ui.fragment.ReleaseDetailFragment
import com.salihakca2.zmovieapp.ui.fragment.ReleaseDetailFragmentArgs
import com.salihakca2.zmovieapp.ui.fragment.ReleasePageFragmentDirections
import com.squareup.picasso.Picasso

class ReleaseMovieAdapter (var mContext: Context, var releaseMovieList : List<ResultXX>)
    :RecyclerView.Adapter<ReleaseMovieAdapter.CardBindingHolderReleaseMovie>(){
    inner class CardBindingHolderReleaseMovie(binding: ReleaseMovieItemBinding): RecyclerView.ViewHolder(binding.root){
        var binding: ReleaseMovieItemBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBindingHolderReleaseMovie {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: ReleaseMovieItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.release_movie_item,parent,false)
       return CardBindingHolderReleaseMovie(binding)
    }

    override fun onBindViewHolder(holder: CardBindingHolderReleaseMovie, position: Int) {
        val releaseMovie = releaseMovieList.get(position)
        val t = holder.binding
        t.releaseMovieObject = releaseMovie

        t.textViewDetailReleaseMovieRate.text =  releaseMovie.voteAverage.toString() + "/ 10"
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + releaseMovie.posterPath).into(t.imageViewReleaseMovieView)
        t.imageViewReleaseMovieView.setOnClickListener {
            val transition = ReleasePageFragmentDirections.actionReleasePageFragmentToReleaseDetailFragment(releaseMovie = releaseMovie)
            Navigation.findNavController(it).navigate(transition)
        }

    }

    override fun getItemCount(): Int {
        return releaseMovieList.size
    }
}