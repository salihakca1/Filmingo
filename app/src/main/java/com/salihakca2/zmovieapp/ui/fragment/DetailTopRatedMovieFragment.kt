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
import com.salihakca2.zmovieapp.data.entity.ResultXXXXX
import com.salihakca2.zmovieapp.data.entity.ResultXXXXXXX
import com.salihakca2.zmovieapp.databinding.FragmentDetailTopRatedMovieBinding
import com.salihakca2.zmovieapp.ui.adapter.CommentAdapter
import com.salihakca2.zmovieapp.ui.adapter.CommentTvAdapter
import com.salihakca2.zmovieapp.ui.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class DetailTopRatedMovieFragment : Fragment() {

    private lateinit var binding: FragmentDetailTopRatedMovieBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_top_rated_movie,container,false)

        val bundle: DetailTopRatedMovieFragmentArgs by navArgs()
        val getObjectMovie = bundle.topRatedMovie

        fetchCommentsMovie(getObjectMovie.id)
        todayDetailMovie(getObjectMovie)
        return binding.root
    }
    fun todayDetailMovie(object7: ResultXXXXXXX) {
        binding.textViewDetailTopRateMovieTitle.text = object7.originalTitle
        binding.textViewDetailTopRateMovieLanguage.text = "Dil: " + object7.originalLanguage
        binding.textViewDetailTopRateMovieOverView.text = object7.overview
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + object7.posterPath)
            .into(binding.imageViewDetailTopRateMovieView)

        viewModel.getObserverLiveDataComments().observe(viewLifecycleOwner) {
            if (it != null) {
                val adapter = CommentAdapter(requireContext(), it.results)
                binding.commentMovieAdapter = adapter
            }
        }
    }

    fun fetchCommentsMovie(movieId: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val job9: Deferred<Unit> = async {
                viewModel.loadComments(movieId)
            }
            job9.await()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }



}