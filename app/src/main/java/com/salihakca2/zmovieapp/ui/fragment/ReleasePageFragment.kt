package com.salihakca2.zmovieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.databinding.FragmentReleasePageBinding
import com.salihakca2.zmovieapp.ui.adapter.ReleaseMovieAdapter
import com.salihakca2.zmovieapp.ui.adapter.ReleaseTvAdapter
import com.salihakca2.zmovieapp.ui.viewmodel.ReleaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class ReleasePageFragment : Fragment() {
    private lateinit var binding: FragmentReleasePageBinding
    private lateinit var viewModel: ReleaseViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_release_page,container,false)

        viewModel.getObserverLiveDataReleaseMovies().observe(viewLifecycleOwner){
            if (it != null){
            val adapter = ReleaseMovieAdapter(requireContext(),it.results)
            binding.releaseMovieAdapter = adapter
            }

       viewModel.getObserverLiveDataReleaseTv().observe(viewLifecycleOwner){
           if (it != null){
               val adapter = ReleaseTvAdapter(requireContext(),it.results)
               binding.releaseTvAdapter = adapter
           }
       }
        }
        fetchReleaseMoviesAndTv()
        return binding.root
    }
    fun fetchReleaseMoviesAndTv(){
        CoroutineScope(Dispatchers.IO).launch {
            val job4: Deferred<Unit> = async {
                viewModel.loadReleaseMovies()
            }
            job4.await()
        }
        CoroutineScope(Dispatchers.IO).launch {
            val job5: Deferred<Unit> = async {
                viewModel.loadReleaseTv()
            }
            job5.await()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ReleaseViewModel by viewModels()
        viewModel = tempViewModel
    }

}