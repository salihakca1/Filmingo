package com.salihakca2.zmovieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.salihakca2.zmovieapp.data.entity.TopRatedMovies
import com.salihakca2.zmovieapp.data.entity.TopRatedTv
import com.salihakca2.zmovieapp.data.repo.MovieDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopRatedViewModel @Inject constructor(var repository: MovieDaoRepository): ViewModel() {
        var topRatedMoviesList: MutableLiveData<TopRatedMovies>
        var topRatedTvList: MutableLiveData<TopRatedTv>
        init {
            topRatedTvList = MutableLiveData()
            topRatedMoviesList = MutableLiveData()
        }

    fun getObserverLiveDataTopRatedMovies(): MutableLiveData<TopRatedMovies>{
        return topRatedMoviesList
    }
    fun getObserverLiveDataTopRatedTv(): MutableLiveData<TopRatedTv>{
        return topRatedTvList
    }

    fun loadTopRated(){
        repository.getTopRatedMovies(topRatedMoviesList)
        repository.getTopRatedTv(topRatedTvList)
    }
}