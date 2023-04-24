package com.example.marvelapp.data.repository

import com.example.marvelapp.BuildConfig
import com.example.marvelapp.data.api.MarvelApi
import com.example.marvelapp.data.model.Characters
import com.example.marvelapp.domain.repository.MarvelRepository

class MarvelRepositoryImpl(private val marvelApi:MarvelApi): MarvelRepository {

    private val apiKey = BuildConfig.API_KEY
    private val hash = BuildConfig.HASH
    private val timestamp = BuildConfig.TS

    override suspend fun getCharacters(): Characters? {
        return marvelApi.getCharacters(apiKey,hash,timestamp).body()
    }
}