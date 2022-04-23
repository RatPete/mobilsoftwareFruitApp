package com.example.fruitapp.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Fruit::class],version =1)
abstract class FruitDatabase:RoomDatabase() {
    abstract fun fruitDao():FruitDao
    companion object{
        @Volatile
        private var INSTANCE: FruitDatabase? =null
        fun getInstance(context: Context): FruitDatabase{
            return INSTANCE?: synchronized(this){
                INSTANCE?: Room.databaseBuilder(context.applicationContext,FruitDatabase::class.java,"fruit_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE =it }
            }
        }
    }
}