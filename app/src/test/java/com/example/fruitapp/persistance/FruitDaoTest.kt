package com.example.fruitapp.persistance

import com.example.fruitapp.persistence.FruitDao
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

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
     * Find fruit by ID
     *
     * Returns a single fruit
     */
    @Test
    fun fruitByIdTest(){
        val fruit=com.example.fruitapp.persistence.Fruit(0,"TestId1Fruit","","","",0.0,0.0,0.0,0,0.0)
        Mockito.`when`(dao?.getFruitByName("TestName")).thenReturn(fruit)
        Assert.assertEquals(dao?.getFruitByName("TestName")!!.calories,fruit.calories)
    }

    /**
     * Return all fruits in the database
     *
     * Returns all the fruits
     */
    @Test
    fun fruitsTest(){
        val fruit=com.example.fruitapp.persistence.Fruit(1,"TestName",
                "",
                "",
                "",
                6.0,
                0.0,
                0.0,
                0,
                0.2,
                )

        val fruitList = mutableListOf<com.example.fruitapp.persistence.Fruit>()
        fruitList.add(fruit)
        Mockito.`when`(dao?.getAllFruits()).thenReturn(fruitList)
        var resFruit=dao?.getAllFruits()
        Assert.assertEquals(resFruit!!.size,1)
    }

}