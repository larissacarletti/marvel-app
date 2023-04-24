package com.example.marvelapp.domain.repository

import com.example.marvelapp.data.model.Characters

interface MarvelRepository {

    suspend fun getCharacters() : Characters?

}
