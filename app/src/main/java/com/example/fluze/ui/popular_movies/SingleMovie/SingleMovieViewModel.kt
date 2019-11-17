package com.example.fluze.ui.popular_movies.SingleMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.fluze.data.repository.NetworkState
import com.example.fluze.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel (private val movieRepository : MainDetaisRepository, movieId: Int)  : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val  movie : LiveData<Movie> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable,movieId)
    }

    val networkState : LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}