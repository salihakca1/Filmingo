package com.salihakca2.zmovieapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.salihakca2.zmovieapp.data.entity.*
import com.salihakca2.zmovieapp.retrofit.MoviesDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieDaoRepository @Inject constructor(var mdao: MoviesDao){
    fun getPopularMovies(liveData: MutableLiveData<Movie>){
        mdao.popularMovies().enqueue(object : Callback<Movie>{
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
            liveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                liveData.postValue(null)
            }
        })
    }
    fun getRecentVideos(liveDataRecentMovies: MutableLiveData<Movie>){
        mdao.getRecentVideos().enqueue(object : Callback<Movie>{
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {

                liveDataRecentMovies.postValue(response.body())
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                    liveDataRecentMovies.postValue(null)
            }

        })
    }
    fun getUsersComment(movieId: Int, liveDataComment: MutableLiveData<Comment>){
        mdao.getCommentMovies(movieId).enqueue(object : Callback<Comment>{
            override fun onResponse(call: Call<Comment>, response: Response<Comment>) {

                liveDataComment.postValue(response.body())
            }

            override fun onFailure(call: Call<Comment>, t: Throwable) {
                liveDataComment.postValue(null)
            }

        })
    }

    fun getReleaseMovies(liveDataReleaseMovies: MutableLiveData<ReleaseMovies>){
        mdao.getReleaseMovies().enqueue(object : Callback<ReleaseMovies>{
            override fun onResponse(call: Call<ReleaseMovies>, response: Response<ReleaseMovies>) {
                liveDataReleaseMovies.postValue(response.body())
            }

            override fun onFailure(call: Call<ReleaseMovies>, t: Throwable) {
                liveDataReleaseMovies.postValue(null)
            }

        })
    }
    fun getReleaseTv(liveDataReleaseTv: MutableLiveData<ReleaseTv>){
        mdao.getReleaseTv().enqueue(object : Callback<ReleaseTv>{
            override fun onResponse(call: Call<ReleaseTv>, response: Response<ReleaseTv>) {
                liveDataReleaseTv.postValue(response.body())
            }

            override fun onFailure(call: Call<ReleaseTv>, t: Throwable) {
                liveDataReleaseTv.postValue(null)
            }

        })
    }

    fun getPopularTv(liveDataPopularTv: MutableLiveData<PopularTv>){
        mdao.getPopularTv().enqueue(object : Callback<PopularTv>{
            override fun onResponse(call: Call<PopularTv>, response: Response<PopularTv>) {
                liveDataPopularTv.postValue(response.body())
            }

            override fun onFailure(call: Call<PopularTv>, t: Throwable) {
                liveDataPopularTv.postValue(null)
            }

        })
    }

    fun getTodayTv(liveDataTodayTv: MutableLiveData<TodayTv>){
        mdao.getTodayTv().enqueue(object : Callback<TodayTv>{
            override fun onResponse(call: Call<TodayTv>, response: Response<TodayTv>) {
                liveDataTodayTv.postValue(response.body())
            }

            override fun onFailure(call: Call<TodayTv>, t: Throwable) {
                liveDataTodayTv.postValue(null)
            }

        })
    }
    fun getCommentTv(tvId: Int,liveDataCommentTv: MutableLiveData<CommentTv>){
        mdao.getCommentTv(tvId).enqueue(object : Callback<CommentTv>{
            override fun onResponse(call: Call<CommentTv>, response: Response<CommentTv>) {
                liveDataCommentTv.postValue(response.body())
            }

            override fun onFailure(call: Call<CommentTv>, t: Throwable) {
                liveDataCommentTv.postValue(null)
            }

        })
    }
    fun getTopRatedMovies(liveDataTopRatedMovie: MutableLiveData<TopRatedMovies>){
        mdao.getTopRatedMovies().enqueue(object : Callback<TopRatedMovies>{
            override fun onResponse(call: Call<TopRatedMovies>, response: Response<TopRatedMovies>) {
                liveDataTopRatedMovie.postValue(response.body())
            }

            override fun onFailure(call: Call<TopRatedMovies>, t: Throwable) {
                liveDataTopRatedMovie.postValue(null)
            }

        })
    }
    fun getTopRatedTv(liveDataTopRatedTv: MutableLiveData<TopRatedTv>){
        mdao.getTopRatedTv().enqueue(object : Callback<TopRatedTv>{
            override fun onResponse(call: Call<TopRatedTv>, response: Response<TopRatedTv>) {
                liveDataTopRatedTv.postValue(response.body())
            }

            override fun onFailure(call: Call<TopRatedTv>, t: Throwable) {
                liveDataTopRatedTv.postValue(null)
            }

        })
    }

}