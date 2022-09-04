package com.salihakca2.zmovieapp.data.entity


import com.google.gson.annotations.SerializedName

data class RecommendMovie(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ResultXXXXXXXXX>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)