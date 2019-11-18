package com.oxcoding.fluze.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.oxcoding.fluze.data.api.TheMovieDBInterface
import com.oxcoding.fluze.data.repository.MovieDetailsNetworkDataSource
import com.oxcoding.fluze.data.repository.NetworkState
import com.oxcoding.fluze.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource =
            MovieDetailsNetworkDataSource(
                apiService,
                compositeDisposable
            )
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}