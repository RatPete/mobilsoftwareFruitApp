package com.example.fruitapp.network

import com.example.fruitapp.io.swagger.client.api.FruitApi
import com.example.fruitapp.io.swagger.client.model.Nutrition
import com.example.fruitapp.persistence.FruitDao
import com.example.fruitapp.presmodels.Fruit
import javax.inject.Inject


open class FruitService @Inject constructor(private val fruitDao:FruitDao,private val fruitApi:FruitApi){
    open fun getFruits(): List<com.example.fruitapp.presmodels.Fruit> {

        var returnList:MutableList<Fruit> = emptyList<Fruit>().toMutableList();
        if(false) {
            val apiList = fruitApi.fruits?.execute()?.body()

            if (apiList != null) {
                for (item in apiList)
                    if (item != null) {
                        returnList.add(convertToPresModelFromApi(item))
                        fruitDao.insertFruit(convertToDaoModelFromPres(convertToPresModelFromApi(item)))
                    }
            }

        }
        else{
            val daoList=fruitDao.getAllFruits()
            for(item in daoList){
                returnList.add(convertToPresModelFromDao(item))
            }
        }
        return returnList
    }
    open fun getFruit( id:Long):Fruit{

                val returnItem=fruitDao.getAllFruits().find { i->i.id==id }
        if(returnItem!=null){
            return convertToPresModelFromDao(returnItem)
        }
        else {
            return Fruit(0,"", "", "", "", 0.0, 0.0, 0.0, 0, 0.0)
        }
    }
    open fun insertFruit(fruit:Fruit){
            fruitDao.insertFruit(convertToDaoModelFromPres(fruit))
            //fruitApi.addFruit(converToApiModel(fruit))?.execute()

    }
    open fun deleteFruit(fruit:Fruit){
            val deletedFruit=convertToDaoModelFromPres(fruit)
            fruitDao.deleteFruit(deletedFruit)
            //fruitApi.deleteFruit(converToApiModelFromPres(fruit).id)?.execute()

    }
    open fun updateFruit(fruit:Fruit){
            val updatedDao=convertToDaoModelFromPres(fruit)
            fruitDao.updateFruit(updatedDao)
            //fruitApi.updateFruit(converToApiModelFromPres(fruit))?.execute()
    }
    open fun convertToPresModelFromApi(item: com.example.fruitapp.io.swagger.client.model.Fruit): Fruit {
        return Fruit(item.id,name = item.name,genus = item.genus,family = item.family,order = item.order,carbohydrates = item.nutritions.carbohydrates,
        sugar = item.nutritions.sugar,protein = item.nutritions.protein,fat = item.nutritions.fat,calories = item.nutritions.calories)
    }
    open fun converToApiModelFromPres(item:com.example.fruitapp.presmodels.Fruit):com.example.fruitapp.io.swagger.client.model.Fruit{
        var fruit= com.example.fruitapp.io.swagger.client.model.Fruit()
        fruit.name=item.name
        fruit.genus=item.genus
        fruit.order=item.order
        fruit.family=item.family
        fruit.id=item.id
        fruit.nutritions= Nutrition()
        fruit.nutritions.calories=item.calories
        fruit.nutritions.carbohydrates=item.carbohydrates
        fruit.nutritions.fat=item.fat
        fruit.nutritions.protein=item.protein
        fruit.nutritions.sugar=item.sugar
        return fruit
    }
    open fun convertToDaoModelFromPres(item:com.example.fruitapp.presmodels.Fruit):com.example.fruitapp.persistence.Fruit{
        return com.example.fruitapp.persistence.Fruit(name = item.name,genus = item.genus,family = item.family,order = item.order,carbohydrates = item.carbohydrates,
            sugar = item.sugar,protein = item.protein,fat = item.fat,calories = item.calories,id=item.id)
    }
    open fun convertToPresModelFromDao(item:com.example.fruitapp.persistence.Fruit):com.example.fruitapp.presmodels.Fruit{
        return com.example.fruitapp.presmodels.Fruit(item.id,item.name,item.genus,item.family,item.order,item.carbohydrates,item.protein,item.fat,item.calories,item.sugar)
    }



}