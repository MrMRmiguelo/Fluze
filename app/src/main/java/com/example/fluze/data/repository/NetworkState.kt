package com.example.fluze.data.repository
enum class Status{
        RUNNING,
        SUCCESS,
        FAILED
}

class NetworkState (val status: Status, val msg: String) {
}