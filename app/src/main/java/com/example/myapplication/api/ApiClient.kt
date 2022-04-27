package com.example.myapplication.api

import com.example.myapplication.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("user/getNumUser")
    fun getData() : Call<User>
}