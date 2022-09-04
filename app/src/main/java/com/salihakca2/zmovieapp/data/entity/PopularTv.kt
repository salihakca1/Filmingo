package com.salihakca2.zmovieapp.data.entity


import com.google.gson.annotations.SerializedName

data class PopularTv(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ResultXXXX>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)