package com.example.fruitapp.network

import com.example.fruitapp.io.swagger.client.api.FruitApi
import com.example.fruitapp.io.swagger.client.model.Nutrition
import com.example.fruitapp.persistence.FruitDao
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(
    MockitoJUnitRunner::class)
class FruitServiceTest {
    private var service: FruitService? = null
    private var realService:FruitService?=null
    private var daoMock:FruitDao?=null
    private var apiMock:FruitApi?=null
    @Before
    fun setup() {
        service = Mockito.mock(FruitService::class.java, Mockito.RETURNS_DEEP_STUBS)
        daoMock=Mockito.mock(FruitDao::class.java)
        apiMock=Mockito.mock(FruitApi::class.java)
        realService= FruitService(daoMock!!,apiMock!!)
    }
    @Test
    fun ApiToPresModelConvertTest(){
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
        fruit.nutritions.sugar=0.3
        val result=realService?.convertToPresModelFromApi(fruit)

        Assert.assertEquals(result!!.id,fruit.id)
    }
    @Test
    fun presToApiConvertTest(){
        val resultFruit=com.example.fruitapp.presmodels.Fruit(6,"TestName","","","",0.0,0.2,0.0,0,0.0)
        val result= realService?.converToApiModelFromPres(resultFruit)
        Assert.assertEquals(result!!.id,resultFruit.id)
    }
    @Test
    fun presToDaoConvertTest(){
        val resultFruit=com.example.fruitapp.presmodels.Fruit(6,"TestName","","","",0.0,0.2,0.0,0,0.0)
        val result=realService?.convertToDaoModelFromPres(resultFruit)
        Assert.assertEquals(result!!.id,resultFruit.id)
    }
    @Test
    fun daoToPresConvertTest(){
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
        val result=realService?.convertToPresModelFromDao(fruit)
        Assert.assertEquals(result!!.id,fruit.id)
    }
    @Test
    fun GetFruitTest(){
        val resultFruit=com.example.fruitapp.persistence.Fruit(6,"TestName","","","",0.0,0.2,0.0,0,0.0)
        val mutableList= mutableListOf<com.example.fruitapp.persistence.Fruit>()
        mutableList.add(resultFruit)
        Mockito.`when`(daoMock?.getAllFruits()).thenReturn(mutableList)
        val res=realService?.getFruit(6)
        Assert.assertEquals(res!!.id,resultFruit.id)
    }
    @Test
    fun GetAllFruitTest(){
        val resultFruit=com.example.fruitapp.persistence.Fruit(6,"TestName","","","",0.0,0.2,0.0,0,0.0)
        val mutableList= mutableListOf<com.example.fruitapp.persistence.Fruit>()
        mutableList.add(resultFruit)
        Mockito.`when`(daoMock?.getAllFruits()).thenReturn(mutableList)
        val res=realService?.getFruits()
        Assert.assertEquals(res!!.size,1)
    }
}