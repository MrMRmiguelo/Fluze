package com.example.fluze.SingleMovie

import androidx.lifecycle.LiveData
import com.example.fluze.data.apiResponse.ApiDBInterface
import com.example.fluze.data.repository.MovieDetailsNetworkDataSource
import com.example.fluze.data.repository.NetworkState
import com.example.fluze.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class MainDetaisRepository (private val apiService : ApiDBInterface) {
    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<Movie> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }

}