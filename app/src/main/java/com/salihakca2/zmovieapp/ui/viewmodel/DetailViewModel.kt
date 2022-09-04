package com.salihakca2.zmovieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.salihakca2.zmovieapp.data.entity.Comment
import com.salihakca2.zmovieapp.data.entity.CommentTv
import com.salihakca2.zmovieapp.data.repo.MovieDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: MovieDaoRepository): ViewModel() {
    var usersCommentTvList: MutableLiveData<CommentTv>
    var usersCommentList: MutableLiveData<Comment>
    init {
        usersCommentTvList = MutableLiveData()
        usersCommentList = MutableLiveData()
    }
    fun getObserverLiveDataCommentsTv(): MutableLiveData<CommentTv>{
        return usersCommentTvList
    }
    fun loadCommentsTv(tvId: Int){
        repository.getCommentTv(tvId,usersCommentTvList)
    }
    fun getObserverLiveDataComments(): MutableLiveData<Comment>{
        return usersCommentList
    }
    fun loadComments(movieId: Int){
        repository.getUsersComment(movieId,usersCommentList)
    }

}