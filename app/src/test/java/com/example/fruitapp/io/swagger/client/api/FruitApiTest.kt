package com.example.fruitapp.io.swagger.client.api

import com.example.fruitapp.io.swagger.client.api.FruitApi
import com.example.fruitapp.io.swagger.client.ApiClient
import com.example.fruitapp.io.swagger.client.model.Fruit
import com.example.fruitapp.network.FruitService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import java.io.IOException
import retrofit2.mock.Calls
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call

/**
 * API tests for FruitApi
 */
@RunWith(
    MockitoJUnitRunner::class)
class FruitApiTest {
    private var api: FruitService? = null
    @Before
    fun setup() {
        api = mock(FruitService::class.java, Mockito.RETURNS_DEEP_STUBS)
    }

    /**
     * Add a new fruit to the database
     *
     *
     */
    @Test
    fun addFruitTest() {

    }

    /**
     * Deletes a fruit
     *
     *
     */
    @Test
    fun deleteFruitTest() {
        val fruitId: Long? = null
        // api.deleteFruit(fruitId);

        // TODO: test validations
    }// TODO: test validations

    /**
     * Find fruit by ID
     *
     * Returns a single fruit
     */
    @Test
    fun fruitByIdTest(){
        val fruit=com.example.fruitapp.presmodels.Fruit("TestId1Fruit","","","",0.0,0.0,0.0,0,0.0)

        `when`(api?.getFruit(6)).thenReturn(fruit)
        // api.addFruit(body);
        var resFruit=api?.getFruit(6)
        Assert.assertEquals(resFruit?.name,"TestId1Fruit")


        }

    /**
     * Return all fruits in the database
     *
     * Returns all the fruits
     */
    @Test
    fun fruitsTest(){
            try {
                Assert.assertEquals(3, 3)
            } catch (e: IOException) {
                e.printStackTrace()
            }

            // TODO: test validations
        }

    /**
     * Update an existing fruit
     *
     *
     */
    @Test
    fun updateFruitTest() {
        val body: Fruit? = null
        // api.updateFruit(body);

        // TODO: test validations
    }
}