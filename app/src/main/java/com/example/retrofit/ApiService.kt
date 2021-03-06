package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api/posts/")
    fun fetchAllPosts(): Call<Post>

    @GET("/users/")
    fun getAllUsers():Call<List<Users>>
}