package com.example.fluze.ui.popular_movies.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.fluze.data.repository.NetworkState
import com.example.fluze.data.vo.Result
import io.reactivex.disposables.CompositeDisposable

class MainActivityViewModel (private val movieRepository : MoviePageListRepository) : ViewModel(){

    private val compositeDisposable = CompositeDisposable()

    val  moviePagedList : LiveData<PagedList<Result>> by lazy {
        movieRepository.fetchLiveMoviePagedList(compositeDisposable)
    }

    val  networkState : LiveData<NetworkState> by lazy {
        movieRepository.getNetworkState()
    }

    fun listIsEmpty(): Boolean {
        return moviePagedList.value?.isEmpty() ?: true
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
