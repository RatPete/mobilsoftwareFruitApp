package com.example.fruitapp.di

import com.example.fruitapp.io.swagger.client.ApiClient
import com.example.fruitapp.io.swagger.client.api.FruitApi
import com.example.fruitapp.network.FruitService
import com.example.fruitapp.persistence.FruitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FruitModule {
    @Provides
    fun provideFruitService(fruitApi:FruitApi,fruitDao:FruitDao): FruitService {
        return FruitService(fruitDao,fruitApi)
    }
}