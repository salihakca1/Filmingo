package com.salihakca2.zmovieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.ResultXX
import com.salihakca2.zmovieapp.data.entity.ResultXXX
import com.salihakca2.zmovieapp.databinding.FragmentReleaseDetailBinding
import com.salihakca2.zmovieapp.ui.viewmodel.ReleaseViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReleaseDetailFragment : Fragment() {
    private lateinit var binding: FragmentReleaseDetailBinding
    private lateinit var viewModel: ReleaseViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_release_detail,container,false)

        val bundle: ReleaseDetailFragmentArgs by navArgs()
        val getObjectReleaseMovie = bundle.releaseMovie


        binding.getReleaseMovieObject = getObjectReleaseMovie

        getMovies(getObjectReleaseMovie!!)

        return binding.root
    }


    fun getMovies(object1: ResultXX){
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + object1.posterPath).into(binding.imageViewDetailView)
        binding.textViewDetailReleaseMovieTitle.text = object1.originalTitle
        binding.textViewDetailReleaseMovieLanguage.text = object1.originalLanguage
        binding.textViewDetailReleaseMovieOverView.text = object1.overview
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ReleaseViewModel by viewModels()
        viewModel = tempViewModel
    }
}