package com.example.fluze.data.apiResponse

import com.example.fluze.data.vo.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiDBInterface {
    //https://api.themoviedb.org/3/movie/popular?api_key=034c86d6bc906024e1abb43009570b16&language=en-US&page=1
    // https://api.themoviedb.org/3/movie/299534?api_key=034c86d6bc906024e1abb43009570b16
    // https://api.themoviedb.org/3/

    //Obtener los datos de las peliculas populares
    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<Movie>
}