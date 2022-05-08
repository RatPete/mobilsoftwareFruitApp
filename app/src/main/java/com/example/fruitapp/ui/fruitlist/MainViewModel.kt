package com.example.fruitapp.ui.fruitlist

import androidx.databinding.Bindable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fruitapp.io.swagger.client.ApiClient
import com.example.fruitapp.presmodels.Fruit
import com.example.fruitapp.network.FruitService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fruitService: FruitService,
    val handle: SavedStateHandle
) :ViewModel() {


    suspend fun ListAllFruits(): List<Fruit> {
        return viewModelScope.async(Dispatchers.IO) {
            fruitService.getFruits()
        }.await()
    }

    suspend fun GetFruit(id: Long): Fruit {
        return viewModelScope.async(Dispatchers.IO) { fruitService.getFruit(id) }.await()
    }

    fun AddFruit(fruit: Fruit) {
        viewModelScope.async(Dispatchers.IO) { fruitService.insertFruit(fruit) }
    }

    fun DeleteFruit(fruit: Fruit) {
        viewModelScope.async(Dispatchers.IO) { fruitService.deleteFruit(fruit) }
    }

    fun UpdateFruit(fruit: Fruit) {
        viewModelScope.async(Dispatchers.IO) { fruitService.updateFruit(fruit) }
    }

    fun UpdateAdapter(adapter: FruitAdapter) {
        viewModelScope.launch(Dispatchers.Main) { adapter.submitList(ListAllFruits()) }
    }

}