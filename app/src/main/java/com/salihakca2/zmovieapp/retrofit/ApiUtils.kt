package com.salihakca2.zmovieapp.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "https://api.themoviedb.org/"

        fun getMoviesDao(): MoviesDao{
            return RetrofitClient.getClient(BASE_URL).create(MoviesDao::class.java)
        }
    }
}