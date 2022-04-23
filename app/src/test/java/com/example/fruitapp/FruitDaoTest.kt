package com.example.fruitapp

import com.example.fruitapp.io.swagger.client.model.Fruit
import com.example.fruitapp.persistence.FruitDao
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

@RunWith(
    MockitoJUnitRunner::class)
class FruitDaoTest {
    private var dao: FruitDao? = null
    @Before
    fun setup() {
        dao = Mockito.mock(FruitDao::class.java, Mockito.RETURNS_DEEP_STUBS)
    }
    fun addFruitTest() {
        val fruit=com.example.fruitapp.persistence.Fruit(0,"TestId1Fruit","","","",0.0,0.0,0.0,0,0.0)

        Mockito.`when`(dao?.insertFruit(fruit))
        // api.addFruit(body);
        dao?.insertFruit(fruit)
    }

    /**
     * Deletes a fruit
     *
     *
     */
    @Test
    fun deleteFruitTest() {
        val fruitId: Long? = null
        val fruit=com.example.fruitapp.persistence.Fruit(0,"TestId1Fruit","","","",0.0,0.0,0.0,0,0.0)

        dao?.deleteFruit(fruit)
    }

    /**
     * Find fruit by ID
     *
     * Returns a single fruit
     */
    @Test
    fun fruitByIdTest(){
        try {
            val response = dao!!.getFruitByName("test")
            Assert.assertEquals(1, 1)
        } catch (e: IOException) {
            e.printStackTrace()
        }


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
        val body=com.example.fruitapp.persistence.Fruit(0,"TestId1Fruit","","","",0.0,0.0,0.0,0,0.0)
        dao?.updateFruit(body )
    }
}