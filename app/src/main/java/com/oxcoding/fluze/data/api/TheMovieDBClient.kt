package com.oxcoding.fluze.data.api

import com.oxcoding.fluze.data.api.TheMovieDBInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_KEY = "034c86d6bc906024e1abb43009570b16"
const val BASE_URL = "https://api.themoviedb.org/3/"

const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

const val FIRST_PAGE = 1
const val POST_PER_PAGE = 20

// https://api.themoviedb.org/3/movie/popular?api_key=034c86d6bc906024e1abb43009570b16&page=1
// https://api.themoviedb.org/3/movie/299534?api_key=034c86d6bc906024e1abb43009570b16
// https://image.tmdb.org/t/p/w342/or06FN3Dka5tukK1e9sl16pB3iy.jpg

object TheMovieDBClient {

    fun getClient(): TheMovieDBInterface {

        val requestInterceptor = Interceptor { chain ->
            // Interceptor take only one argument which is a lambda function so parenthesis can be omitted

            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)   //explicitly return a value from whit @ annotation. lambda always returns the value of the last expression implicitly
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheMovieDBInterface::class.java)

    }
}