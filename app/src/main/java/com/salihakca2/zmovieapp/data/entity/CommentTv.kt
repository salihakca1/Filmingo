package com.salihakca2.zmovieapp.data.entity


import com.google.gson.annotations.SerializedName

data class CommentTv(
    @SerializedName("id")
    val id: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ResultXXXXXX>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)