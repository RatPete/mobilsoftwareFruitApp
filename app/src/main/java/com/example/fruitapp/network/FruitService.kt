package com.example.fruitapp.network

import com.example.fruitapp.io.swagger.client.ApiClient
import com.example.fruitapp.io.swagger.client.api.FruitApi
import com.example.fruitapp.io.swagger.client.model.Nutrition
import com.example.fruitapp.persistence.FruitDao
import com.example.fruitapp.persistence.FruitDatabase
import com.example.fruitapp.presmodels.Fruit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


open class FruitService @Inject constructor(private val fruitDao:FruitDao,private val fruitApi:FruitApi){

    open fun getFruits(): List<com.example.fruitapp.presmodels.Fruit> {
        var returnList:MutableList<Fruit> = emptyList<Fruit>().toMutableList();
        val apiList=fruitApi.fruits?.execute()?.body();
        if(apiList!=null){
            for (item in apiList)
                if(item!=null){
                   returnList.add(convertToPresModel(item))
                }
        }
        return returnList
    }
    open fun getFruit( id:Long):Fruit{
        val returnItem=fruitApi.getFruitById(id)?.execute()?.body()
        if(returnItem!=null){
            return convertToPresModel(returnItem)
        }
        else{
            return Fruit("","","","",0.0,0.0,0.0,0,0.0)
        }
    }
    open fun insertFruit(fruit:Fruit){
        Thread {
            fruitDao.insertFruit(convertToDaoModel(fruit))
            fruitApi.addFruit(converToApiModel(fruit))?.execute()

        }.start()
    }
    open fun deleteFruit(fruit:Fruit){
        Thread {
            fruitDao.deleteFruit(convertToDaoModel(fruit))
            fruitApi.deleteFruit(converToApiModel(fruit).id)?.execute()
        }.start()
    }
    open fun updateFruit(fruit:Fruit){
        Thread{
            fruitDao.updateFruit(convertToDaoModel(fruit))
            fruitApi.updateFruit(converToApiModel(fruit))?.execute()
        }.start()
    }
    private fun convertToPresModel(item: com.example.fruitapp.io.swagger.client.model.Fruit): Fruit {
        return Fruit(name = item.name,genus = item.genus,family = item.family,order = item.order,carbohydrates = item.nutritions.carbohydrates,
        sugar = item.nutritions.sugar,protein = item.nutritions.protein,fat = item.nutritions.fat,calories = item.nutritions.calories)
    }
    private fun converToApiModel(item:com.example.fruitapp.presmodels.Fruit):com.example.fruitapp.io.swagger.client.model.Fruit{
        var fruit= com.example.fruitapp.io.swagger.client.model.Fruit()
        fruit.name=item.name
        fruit.genus=item.genus
        fruit.order=item.order
        fruit.family=item.family
        fruit.id=100
        fruit.nutritions= Nutrition()
        fruit.nutritions.calories=item.calories
        fruit.nutritions.carbohydrates=item.carbohydrates
        fruit.nutritions.fat=item.fat
        fruit.nutritions.protein=item.protein
        fruit.nutritions.sugar=item.sugar
        return fruit
    }
    private fun convertToDaoModel(item:com.example.fruitapp.presmodels.Fruit):com.example.fruitapp.persistence.Fruit{
        return com.example.fruitapp.persistence.Fruit(name = item.name,genus = item.genus,family = item.family,order = item.order,carbohydrates = item.carbohydrates,
            sugar = item.sugar,protein = item.protein,fat = item.fat,calories = item.calories,id=null)
    }



}