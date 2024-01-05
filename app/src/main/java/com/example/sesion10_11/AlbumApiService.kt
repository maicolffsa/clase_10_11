package com.example.sesion10_11

import retrofit2.Call
import retrofit2.http.GET

interface AlbumApiService {

    @GET("albums/")
    fun getAllPosts(): Call<List<Album>>
}