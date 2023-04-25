package com.example.marvelapp.data.model


import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("extension")
    val extension: String,
    @SerializedName("poster_path")
    val path: String
)