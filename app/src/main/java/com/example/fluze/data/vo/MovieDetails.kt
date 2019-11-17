package com.example.fluze.data.vo


import com.google.gson.annotations.SerializedName

data class MovieDetails(
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String
)