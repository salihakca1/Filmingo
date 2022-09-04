package com.salihakca2.zmovieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.salihakca2.zmovieapp.data.entity.Movie
import com.salihakca2.zmovieapp.data.repo.MovieDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor (private val repo: MovieDaoRepository) : ViewModel() {

    var popularMovieList: MutableLiveData<Movie>
    var recentMoviesList: MutableLiveData<Movie>
    init {
        recentMoviesList = MutableLiveData()
        popularMovieList = MutableLiveData()
    }

    fun getObserverLiveDataRecentMovies(): MutableLiveData<Movie>{
        return recentMoviesList
    }
    fun getObserverLiveData(): MutableLiveData<Movie>{
        return popularMovieList
    }

    fun loadRecentData(){
        repo.getRecentVideos(recentMoviesList)
    }
    fun loadPopularData(){
        repo.getPopularMovies(popularMovieList)
    }

}