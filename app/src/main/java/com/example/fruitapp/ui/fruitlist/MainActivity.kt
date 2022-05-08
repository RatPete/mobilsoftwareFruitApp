package com.example.fruitapp.ui.fruitlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView

import com.example.fruitapp.R
import com.example.fruitapp.io.swagger.client.model.Fruit
import com.example.fruitapp.ui.fruitadd.AddActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val fruitsViewModel: MainViewModel by viewModels()
    lateinit var fruitAdapter: FruitAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecylcerView()
        }

    private fun initRecylcerView() {
        fruitAdapter= FruitAdapter(this,fruitsViewModel)
        val view: RecyclerView=findViewById(R.id.listFruit)
        view.adapter=fruitAdapter
        lifecycleScope.launch(Dispatchers.Main) {
            fruitAdapter.submitList(fruitsViewModel.ListAllFruits())
        }
    }

    override fun onRestart() {
        super.onRestart()
        lifecycleScope.launch(Dispatchers.Main){
            fruitAdapter.submitList(fruitsViewModel.ListAllFruits())
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch(Dispatchers.Main){
            fruitAdapter.submitList(fruitsViewModel.ListAllFruits())
        }
    }
    fun addNewFruit(view :View){
        val intent=Intent(view.context,AddActivity::class.java)
        view.context.startActivity(intent)
    }

}