package com.example.fruitapp.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fruit")
data class Fruit (
    @PrimaryKey(autoGenerate = true)var id:Long?,
    var name:String,
    var genus:String,
    var family:String,
    var order:String,
    var carbohydrates:Double,
    var protein: Double,
    var fat:Double,
    var calories:Long,
    var sugar: Double)
