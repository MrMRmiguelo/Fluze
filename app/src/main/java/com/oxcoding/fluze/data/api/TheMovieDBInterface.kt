package com.oxcoding.fluze.data.api

import com.oxcoding.fluze.data.vo.MovieDetails
import com.oxcoding.fluze.data.vo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {

    // https://api.themoviedb.org/3/movie/popular?api_key=034c86d6bc906024e1abb43009570b16&page=1
    // https://api.themoviedb.org/3/movie/299534?api_key=034c86d6bc906024e1abb43009570b16
    // https://api.themoviedb.org/3/

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}