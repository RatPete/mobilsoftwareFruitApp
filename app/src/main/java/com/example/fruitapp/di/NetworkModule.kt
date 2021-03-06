package com.example.fruitapp.di

import com.example.fruitapp.io.swagger.client.ApiClient
import com.example.fruitapp.io.swagger.client.api.FruitApi
import com.example.fruitapp.persistence.FruitDao
import com.example.fruitapp.persistence.FruitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideFruitApi(): FruitApi {
        return ApiClient().createService(FruitApi::class.java)
    }
}