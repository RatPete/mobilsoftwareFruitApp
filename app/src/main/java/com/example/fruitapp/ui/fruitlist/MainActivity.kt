package com.example.fruitapp.ui.fruitlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fruitapp.R
import com.example.fruitapp.persistence.Fruit
import com.example.fruitapp.persistence.FruitDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}