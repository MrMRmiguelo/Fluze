package com.example.fluze.ui.popular_movies.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.fluze.data.apiResponse.ApiDBInterface
import com.example.fluze.data.apiResponse.POST_PER_PAGE
import com.example.fluze.data.repository.MovieDataSource
import com.example.fluze.data.repository.MovieDataSourceFactory
import com.example.fluze.data.repository.NetworkState
import com.example.fluze.data.vo.Result
import io.reactivex.disposables.CompositeDisposable

class MoviePageListRepository (private val apiService : ApiDBInterface){
    lateinit var moviePagedList: LiveData<PagedList<Result>>
    lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList (compositeDisposable: CompositeDisposable) : LiveData<PagedList<Result>> {
        moviesDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()

        return moviePagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap<MovieDataSource, NetworkState>(
            moviesDataSourceFactory.moviesLiveDataSource, MovieDataSource::networkState)
    }
}