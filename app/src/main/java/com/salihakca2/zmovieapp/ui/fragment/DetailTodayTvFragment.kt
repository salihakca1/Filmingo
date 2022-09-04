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
import com.salihakca2.zmovieapp.databinding.FragmentDetailTodayTvBinding
import com.salihakca2.zmovieapp.ui.adapter.CommentTvAdapter
import com.salihakca2.zmovieapp.ui.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class DetailTodayTvFragment : Fragment() {
    private lateinit var binding: FragmentDetailTodayTvBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_today_tv,container,false)

        val bundle: DetailTodayTvFragmentArgs by navArgs()
        val getObjectPopularTv = bundle.todayTvObject


        fetchCommentsTv(getObjectPopularTv.id)
        todayDetailTv(getObjectPopularTv)
        return binding.root
    }


    fun todayDetailTv(object5: ResultXXXXX){
        binding.textViewDetailTodayTvTitle.text = object5.originalName
        binding.textViewDetailTodayTvLanguage.text= "Dil: "+ object5.originalLanguage
        binding.textViewDetailTodayTvOverView.text = object5.overview
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + object5.posterPath).into(binding.imageViewDetailTodayTvView)

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