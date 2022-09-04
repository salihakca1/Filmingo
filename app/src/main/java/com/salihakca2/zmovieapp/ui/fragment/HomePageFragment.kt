package com.salihakca2.zmovieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.databinding.FragmentHomePageBinding
import com.salihakca2.zmovieapp.ui.adapter.PopularAdapter
import com.salihakca2.zmovieapp.ui.adapter.RecentAdapter
import com.salihakca2.zmovieapp.ui.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var viewModel: HomePageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page,container,false)

        viewModel.getObserverLiveData().observe(viewLifecycleOwner){
            if (it != null){
                val adapter = PopularAdapter(requireContext(),it.results)
                binding.popularAdapter = adapter
            }
        }

        viewModel.getObserverLiveDataRecentMovies().observe(viewLifecycleOwner){
            if (it != null){
                val adapter = RecentAdapter(requireContext(), it.results)
                binding.recentAdapter = adapter
            }
        }

        fetchPopularMovies()
        return binding.root
    }

    private fun fetchPopularMovies() {

        CoroutineScope(Dispatchers.IO).launch {
        val job1: Deferred<Unit> = async {
            viewModel.loadPopularData()
        }
            job1.await()
        }

        CoroutineScope(Dispatchers.IO).launch {
            val job2: Deferred<Unit> = async {
                viewModel.loadRecentData()
            }
            job2.await()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomePageViewModel by viewModels()
        viewModel = tempViewModel
    }




}