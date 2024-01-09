package com.example.volleyapikotlin.api

interface ApiCallback<T> {
    fun onSuccess(result: T?)
    fun onError(error: String)
}