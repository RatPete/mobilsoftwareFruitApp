package com.example.fruitapp.ui.fruitdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fruitapp.R
import com.example.fruitapp.databinding.ActivityDetailsBinding
import com.example.fruitapp.presmodels.Fruit
import com.example.fruitapp.ui.fruitlist.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private val viewModel:MainViewModel by viewModels()
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val name=intent.getLongExtra("fruit",0)
        this.binding =DataBindingUtil.setContentView(this,R.layout.activity_details)
        this.binding.fruit=Fruit(null,"","","","",0.0,0.0,0.0,0,0.0)
        lifecycleScope.launch(Dispatchers.Main){
            val fruit = viewModel.GetFruit(name)
            binding.fruit=fruit

        }

    }
}