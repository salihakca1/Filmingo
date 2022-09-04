package com.salihakca2.zmovieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.ResultXXXXXXX
import com.salihakca2.zmovieapp.data.entity.ResultXXXXXXXX
import com.salihakca2.zmovieapp.databinding.FragmentDetailTopRatedTvBinding
import com.salihakca2.zmovieapp.ui.adapter.CommentAdapter
import com.salihakca2.zmovieapp.ui.adapter.CommentTvAdapter
import com.salihakca2.zmovieapp.ui.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class DetailTopRatedTvFragment : Fragment() {
    private lateinit var binding: FragmentDetailTopRatedTvBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_top_rated_tv,container,false)


        val bundle: DetailTopRatedTvFragmentArgs by navArgs()
        val getObjectTv = bundle.topRatedTv

        todayDetailTv(getObjectTv)
        fetchCommentsTv(getObjectTv.id)
        return binding.root
    }

    fun todayDetailTv(object8: ResultXXXXXXXX) {
        binding.textViewDetailTopRateTvTitle.text = object8.originalName
        binding.textViewDetailTopRateTvLanguage.text = "Dil: " + object8.originalLanguage
        binding.textViewDetailTopRateTvOverView.text = object8.overview
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + object8.posterPath)
            .into(binding.imageViewDetailTopRateTvView)

        viewModel.getObserverLiveDataCommentsTv().observe(viewLifecycleOwner) {
            if (it != null) {
                val adapter = CommentTvAdapter(requireContext(), it.results)
                binding.commentTvAdapter = adapter
            }
        }
    }
    fun fetchCommentsTv(tvId: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val job10: Deferred<Unit> = async {
                viewModel.loadCommentsTv(tvId)
            }
            job10.await()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }
}