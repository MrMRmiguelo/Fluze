package com.example.fluze

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity


class Network {
    companion object {
        fun verifyConnection(activity: AppCompatActivity): Boolean {
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetwork

            return networkInfo != null
        }
    }
}