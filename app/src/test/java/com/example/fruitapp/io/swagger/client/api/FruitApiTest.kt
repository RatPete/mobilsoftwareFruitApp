package com.example.fruitapp.io.swagger.client.api

import com.example.fruitapp.io.swagger.client.model.Nutrition
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import retrofit2.mock.Calls
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * API tests for FruitApi
 */
@RunWith(
    MockitoJUnitRunner::class)
class FruitApiTest {
    private var api: FruitApi? = null
    @Before
    fun setup() {
        api = mock(FruitApi::class.java, Mockito.RETURNS_DEEP_STUBS)
    }
    /**
     * Find fruit by ID
     *
     * Returns a single fruit
     */
    @Test
    fun fruitByIdTest(){
        val fruit=com.example.fruitapp.io.swagger.client.model.Fruit()
        fruit.name="TestName"
        fruit.genus=""
        fruit.order=""
        fruit.family=""
        fruit.id=6
        fruit.nutritions= Nutrition()
        fruit.nutritions.calories=0
        fruit.nutritions.carbohydrates=0.0
        fruit.nutritions.fat=0.0
        fruit.nutritions.protein=0.2
        fruit.nutritions.sugar=0.0

        `when`(api?.getFruitById(6)).thenReturn(Calls.response(fruit))
        var resFruit=api?.getFruitById(6)
        Assert.assertEquals(resFruit!!.execute().body()!!.name,"TestName")


        }

    /**
     * Return all fruits in the database
     *
     * Returns all the fruits
     */
    @Test
    fun fruitsTest(){
        val fruit=com.example.fruitapp.io.swagger.client.model.Fruit()
        fruit.name="TestName"
        fruit.genus=""
        fruit.order=""
        fruit.family=""
        fruit.id=6
        fruit.nutritions= Nutrition()
        fruit.nutritions.calories=0
        fruit.nutritions.carbohydrates=0.0
        fruit.nutritions.fat=0.0
        fruit.nutritions.protein=0.2
        fruit.nutritions.sugar=0.0
        val fruitList = mutableListOf<com.example.fruitapp.io.swagger.client.model.Fruit>()
        fruitList.add(fruit)
        `when`(api?.fruits).thenReturn(Calls.response(fruitList))
        var resFruit=api?.fruits
        Assert.assertEquals(resFruit!!.execute().body()!!.size,1)
    }


}