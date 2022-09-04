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
import com.salihakca2.zmovieapp.data.entity.Result
import com.salihakca2.zmovieapp.data.entity.ResultXXXX
import com.salihakca2.zmovieapp.data.entity.ResultXXXXX
import com.salihakca2.zmovieapp.data.entity.ResultXXXXXX
import com.salihakca2.zmovieapp.databinding.FragmentTvDetailBinding
import com.salihakca2.zmovieapp.ui.adapter.CommentAdapter
import com.salihakca2.zmovieapp.ui.adapter.CommentTvAdapter
import com.salihakca2.zmovieapp.ui.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class TvDetailFragment : Fragment() {

    private lateinit var binding: FragmentTvDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tv_detail,container,false)

        val bundle: TvDetailFragmentArgs by navArgs()
        val getObjectPopularTv = bundle.popularTvObject

        popularDetailTv(getObjectPopularTv)

        fetchCommentsTv(getObjectPopularTv.id)
        return binding.root
    }


    fun popularDetailTv(object4: ResultXXXX){
        binding.textViewDetailTvTitle.text = object4.originalName
        binding.textViewDetailTvLanguage.text = "Dil: "+ object4.originalLanguage
        binding.textViewDetailTvOverView.text = object4.overview
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + object4.posterPath).into(binding.imageViewDetailTvView)

        viewModel.getObserverLiveDataCommentsTv().observe(viewLifecycleOwner){
            if (it != null){
                val adapter = CommentTvAdapter(requireContext(),it.results)
                binding.commentTvAdapter = adapter
            }
        }

    }

    fun fetchCommentsTv(tvId: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val job7: Deferred<Unit> = async {
                viewModel.loadCommentsTv(tvId)
            }
            job7.await()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }

}