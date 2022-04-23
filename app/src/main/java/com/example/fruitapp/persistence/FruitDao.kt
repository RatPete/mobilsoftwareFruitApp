package com.example.fruitapp.persistence

import androidx.room.*

@Dao
interface FruitDao {
    @Query("""SELECT * FROM fruit""")
    fun getAllFruits(): List<Fruit>
    @Query("SELECT * FROM fruit WHERE name=:name")
    fun getFruitByName(name:String): Fruit
    @Insert
    fun insertFruit(vararg fruits:Fruit)
    @Delete
    fun deleteFruit(fruit:Fruit)
    @Query("DELETE FROM fruit")
    fun deleteAllFruits()
    @Update
    fun updateFruit(fruit:Fruit)
}