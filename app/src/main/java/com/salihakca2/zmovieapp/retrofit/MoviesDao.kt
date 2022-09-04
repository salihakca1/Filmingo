package com.salihakca2.zmovieapp.retrofit

import com.salihakca2.zmovieapp.data.entity.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesDao {

        @GET("3/movie/popular?api_key=3d52c187a80fd10f09ff83180ccd4cb3&language=tr-TR")
        fun popularMovies(): Call<Movie>

        @GET("3/movie/now_playing?api_key=3d52c187a80fd10f09ff83180ccd4cb3&language=tr-TR")
        fun getRecentVideos(): Call<Movie>

        @GET("3/movie/{movie_id}/reviews?api_key=3d52c187a80fd10f09ff83180ccd4cb3&language=en-US&page=1")
        fun getCommentMovies(@Path("movie_id") movieId: Int): Call<Comment>

        @GET("3/movie/upcoming?api_key=3d52c187a80fd10f09ff83180ccd4cb3&language=tr-TR&page=1")
        fun getReleaseMovies(): Call<ReleaseMovies>

        @GET("3/tv/on_the_air?api_key=3d52c187a80fd10f09ff83180ccd4cb3&language=tr-TR&page=1")
        fun getReleaseTv(): Call<ReleaseTv>

        @GET("3/tv/popular?api_key=3d52c187a80fd10f09ff83180ccd4cb3&language=tr-TR&page=1")
        fun getPopularTv(): Call<PopularTv>

        @GET("3/tv/airing_today?api_key=3d52c187a80fd10f09ff83180ccd4cb3&language=tr-TR&page=1")
        fun getTodayTv(): Call<TodayTv> //bugünün tv şovları, ResultXXXXX ile adaptere aktarcaz

        @GET("3/tv/{tv_id}/reviews?api_key=3d52c187a80fd10f09ff83180ccd4cb3&language=en-US&page=1")
        fun getCommentTv(@Path("tv_id") tvId: Int): Call<CommentTv>

        @GET("3/movie/top_rated?api_key=3d52c187a80fd10f09ff83180ccd4cb3&language=tr-TR&page=1")
        fun getTopRatedMovies(): Call<TopRatedMovies>

        @GET("3/tv/top_rated?api_key=3d52c187a80fd10f09ff83180ccd4cb3&language=tr-TR&page=1")
        fun getTopRatedTv(): Call<TopRatedTv>


}