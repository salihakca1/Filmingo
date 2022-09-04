package com.salihakca2.zmovieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.databinding.FragmentTvPageBinding
import com.salihakca2.zmovieapp.ui.adapter.PopularTvAdapter
import com.salihakca2.zmovieapp.ui.adapter.TodayTvAdapter
import com.salihakca2.zmovieapp.ui.viewmodel.TvPageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class TvPageFragment : Fragment() {
    private lateinit var binding: FragmentTvPageBinding
    private lateinit var viewModel: TvPageViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tv_page,container,false)

        viewModel.getObserverLiveDataPopularTv().observe(viewLifecycleOwner){
            if (it != null){
                val adapter = PopularTvAdapter(requireContext(),it.results)
                binding.popularTvAdapter = adapter
            }
        }
        viewModel.getObserverLiveDataTodayTv().observe(viewLifecycleOwner){
            if (it != null){
                val adapter = TodayTvAdapter(requireContext(),it.results)
                binding.todayTvAdapter = adapter
            }
        }

        fetchPopularAndTodayTv()
        return binding.root
    }
    fun fetchPopularAndTodayTv(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                viewModel.loadPopularAndTodayTv()
            }
            job6.await()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TvPageViewModel by viewModels()
        viewModel = tempViewModel
    }

}