package com.salihakca2.zmovieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.salihakca2.zmovieapp.data.entity.ReleaseMovies
import com.salihakca2.zmovieapp.data.entity.ReleaseTv
import com.salihakca2.zmovieapp.data.repo.MovieDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReleaseViewModel @Inject constructor(private val repository: MovieDaoRepository) : ViewModel(){
    var releaseMoviesList: MutableLiveData<ReleaseMovies>
    var releaseTvList: MutableLiveData<ReleaseTv>
    init {
        releaseTvList = MutableLiveData()
        releaseMoviesList = MutableLiveData()
    }
    fun getObserverLiveDataReleaseMovies(): MutableLiveData<ReleaseMovies>{
        return releaseMoviesList
    }
    fun getObserverLiveDataReleaseTv(): MutableLiveData<ReleaseTv>{
        return releaseTvList
    }
    fun loadReleaseTv(){
        repository.getReleaseTv(releaseTvList)
    }
    fun loadReleaseMovies(){
        repository.getReleaseMovies(releaseMoviesList)
    }
}
