package com.example.marvelapp.data.api

import com.example.marvelapp.data.model.Characters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MarvelApi {

    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") timestamp: String
    ) : Response<Characters>



}