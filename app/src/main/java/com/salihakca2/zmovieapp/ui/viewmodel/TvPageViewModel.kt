package com.salihakca2.zmovieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.salihakca2.zmovieapp.data.entity.PopularTv
import com.salihakca2.zmovieapp.data.entity.TodayTv
import com.salihakca2.zmovieapp.data.repo.MovieDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvPageViewModel @Inject constructor(private val repository: MovieDaoRepository): ViewModel() {

    var popularTvList: MutableLiveData<PopularTv>
    var todayTvList: MutableLiveData<TodayTv>
    init {
        todayTvList = MutableLiveData()
        popularTvList = MutableLiveData()
    }

    fun getObserverLiveDataTodayTv(): MutableLiveData<TodayTv>{
        return todayTvList
    }
    fun getObserverLiveDataPopularTv(): MutableLiveData<PopularTv> {
        return popularTvList
    }
    fun loadPopularAndTodayTv(){
        repository.getPopularTv(popularTvList)
        repository.getTodayTv(todayTvList)
    }
}