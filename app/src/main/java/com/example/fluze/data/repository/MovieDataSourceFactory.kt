package com.example.fluze.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.fluze.data.apiResponse.ApiDBInterface
import com.example.fluze.data.vo.Result
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory (private val apiService : ApiDBInterface, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Result>() {


    val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Result> {
        val movieDataSource = MovieDataSource(apiService,compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}