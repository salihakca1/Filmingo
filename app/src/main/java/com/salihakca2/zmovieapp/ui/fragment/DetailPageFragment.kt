package com.salihakca2.zmovieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.Result
import com.salihakca2.zmovieapp.databinding.FragmentDetailPageBinding
import com.salihakca2.zmovieapp.ui.adapter.CommentAdapter
import com.salihakca2.zmovieapp.ui.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class DetailPageFragment : Fragment() {

    private lateinit var binding: FragmentDetailPageBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_page,container,false)

        val bundle: DetailPageFragmentArgs by navArgs()
        val getObjectPopular = bundle.movie

        popularDetail(getObjectPopular)
        fetchComments(getObjectPopular.id)
        return binding.root
    }

    fun popularDetail(object1: Result){
        binding.textViewDetailTitle.text = object1.title
        binding.textViewDetailLanguage.text = "Dil: "+object1.originalLanguage
        binding.textViewDetailOverView.text = object1.overview


        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + object1.posterPath).into(binding.imageViewDetailView)

        viewModel.getObserverLiveDataComments().observe(viewLifecycleOwner){
            if (it != null){
                val adapter = CommentAdapter(requireContext(),it.results)
                binding.commentAdapter = adapter
            }
        }

    }
    fun fetchComments(movieId: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val job3: Deferred<Unit> = async {
                viewModel.loadComments(movieId)
            }
            job3.await()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetailViewModel by viewModels()
        viewModel = tempViewModel
    }


}