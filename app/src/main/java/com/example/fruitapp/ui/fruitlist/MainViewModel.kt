package com.example.fruitapp.ui.fruitlist

import com.example.fruitapp.io.swagger.client.ApiClient
import com.example.fruitapp.presmodels.Fruit
import com.example.fruitapp.network.FruitService
import javax.inject.Inject

class MainViewModel @Inject constructor(private val fruitService: FruitService) {
    fun ListAllFruits():List<Fruit>{
        return fruitService.getFruits();
    }
    fun GetFruit(id:Long):Fruit{
        return fruitService.getFruit(id)
    }
    fun AddFruit(fruit:Fruit){
        fruitService.insertFruit(fruit)
    }
    fun DeleteFruit(fruit:Fruit){
        fruitService.deleteFruit(fruit)
    }
    fun UpdateFruit(fruit:Fruit){
        fruitService.updateFruit(fruit)
    }

}