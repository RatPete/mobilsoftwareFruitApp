package com.example.fruitapp.io.swagger.client.api

import com.example.fruitapp.io.swagger.client.model.Fruit
import retrofit2.Call
import retrofit2.http.*

public interface FruitApi {
    /**
     * Add a new fruit to the database
     *
     * @param body Fruit object that needs to be added to the database (required)
     * @return Call&lt;Void&gt;
     */
    @Headers("Content-Type:application/json")
    @POST("fruit")
    fun addFruit(
        @Body body: Fruit?
    ): Call<Void?>?

    /**
     * Deletes a fruit
     *
     * @param fruitId Fruit id to delete (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("fruit/{fruitId}")
    fun deleteFruit(
        @Path("fruitId") fruitId: Long?
    ): Call<Void?>?

    /**
     * Find fruit by ID
     * Returns a single fruit
     * @param fruitId ID of fruit to return (required)
     * @return Call&lt;Fruit&gt;
     */
    @GET("fruit/{fruitId}")
    fun getFruitById(
        @Path("fruitId") fruitId: Long?
    ): Call<Fruit?>?

    /**
     * Return all fruits in the database
     * Returns all the fruits
     * @return Call&lt;List&lt;Fruit&gt;&gt;
     */
    @get:GET("fruit/all")
    val fruits: Call<List<Fruit?>?>?

    /**
     * Update an existing fruit
     *
     * @param body Fruit object that needs to be added to the database (required)
     * @return Call&lt;Void&gt;
     */
    @Headers("Content-Type:application/json")
    @PUT("fruit")
    fun updateFruit(
        @Body body: Fruit?
    ): Call<Void?>?
}