package com.example.volleyapikotlin.api

import com.example.volleyapikotlin.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}