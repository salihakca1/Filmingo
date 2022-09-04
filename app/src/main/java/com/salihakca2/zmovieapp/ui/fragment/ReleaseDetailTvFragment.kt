package com.salihakca2.zmovieapp.ui.fragment

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.ResultXXX
import com.salihakca2.zmovieapp.databinding.FragmentReleaseDetailTvBinding
import com.salihakca2.zmovieapp.ui.viewmodel.ReleaseViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReleaseDetailTvFragment : Fragment() {

    private lateinit var binding: FragmentReleaseDetailTvBinding
    private lateinit var viewModel: ReleaseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_release_detail_tv,container,false)
        val bundle: ReleaseDetailTvFragmentArgs by navArgs()
        val getObjectReleaseTv = bundle.releaseTv

        getTv(getObjectReleaseTv)

        return binding.root
    }
    fun getTv(object2: ResultXXX){
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + object2.posterPath).into(binding.imageViewDetailView)
        binding.textViewDetailReleaseMovieTitle.text = object2.originalName
        binding.textViewDetailReleaseMovieLanguage.text = object2.originalLanguage
        binding.textViewDetailReleaseMovieOverView.text = object2.overview
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ReleaseViewModel by viewModels()
        viewModel = tempViewModel
    }

}