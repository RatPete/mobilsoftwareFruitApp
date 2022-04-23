package com.example.fruitapp.di

import android.content.Context
import androidx.room.Room
import com.example.fruitapp.persistence.FruitDao
import com.example.fruitapp.persistence.FruitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistanceModule {
    @Provides
    fun provideFruitDao(fruitDataBase:FruitDatabase):FruitDao{
        return fruitDataBase.fruitDao()
    }
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): FruitDatabase {
        return Room.databaseBuilder(
            appContext,
            FruitDatabase::class.java,
            "fruit_database"
        ).build()
    }
}