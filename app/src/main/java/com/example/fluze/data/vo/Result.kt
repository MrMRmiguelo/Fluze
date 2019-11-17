package com.example.fluze.data.vo


import com.google.gson.annotations.SerializedName

data class Result(

    @SerializedName("id")
    val id: Int,

    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String

)