package com.salihakca2.zmovieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.databinding.FragmentTopRatedBinding
import com.salihakca2.zmovieapp.ui.adapter.TopRatedMovieAdapter
import com.salihakca2.zmovieapp.ui.adapter.TopRatedTvAdapter
import com.salihakca2.zmovieapp.ui.viewmodel.TopRatedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class TopRatedFragment : Fragment() {
    private lateinit var binding: FragmentTopRatedBinding
    private lateinit var viewModel: TopRatedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_top_rated,container,false)

        viewModel.getObserverLiveDataTopRatedMovies().observe(viewLifecycleOwner){
            if (it != null){
                val adapter = TopRatedMovieAdapter(requireContext(),it.results)
                binding.topRatedMovieAdapter = adapter
            }
        }

        viewModel.getObserverLiveDataTopRatedTv().observe(viewLifecycleOwner){
            if (it != null){
                val adapter = TopRatedTvAdapter(requireContext(),it.results)
                binding.topRatedTvAdapter = adapter
            }
        }
        fetchTopRate()
        return binding.root
    }
    fun fetchTopRate(){
        CoroutineScope(Dispatchers.IO).launch {
            val job7: Deferred<Unit> = async {
                viewModel.loadTopRated()
            }
            job7.await()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TopRatedViewModel by viewModels()
        viewModel = tempViewModel
    }
}