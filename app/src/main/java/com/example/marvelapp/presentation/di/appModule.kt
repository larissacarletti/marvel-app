package com.example.marvelapp.presentation.di

import com.example.marvelapp.BuildConfig
import com.example.marvelapp.data.api.MarvelApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object appModule {

    private const val baseUrl: String = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideMyApi() : MarvelApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

}