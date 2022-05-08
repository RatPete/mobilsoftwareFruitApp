package com.example.fruitapp.ui.fruitadd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fruitapp.R
import com.example.fruitapp.databinding.ActivityAddBinding
import com.example.fruitapp.databinding.ActivityDetailsBinding
import com.example.fruitapp.persistence.FruitDatabase
import com.example.fruitapp.presmodels.Fruit
import com.example.fruitapp.ui.fruitlist.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@AndroidEntryPoint
class AddActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding:ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        this.binding = DataBindingUtil.setContentView(this,R.layout.activity_add)
        this.binding.fruit=com.example.fruitapp.presmodels.Fruit(null,"", "", "", "", 0.0, 0.0, 0.0, 0, 0.0)

    }
    fun addNewFruit(view:View){
        val fruit= createFruitFromForm()
        Log.println(Log.WARN,"TestLog",fruit.toString())
        viewModel.AddFruit(fruit)
        finish()
    }
    private fun createFruitFromForm(): Fruit {
        var fruit: Fruit
        val name:String=findViewById<EditText>(R.id.name).text.toString()
        val genus:String=findViewById<EditText>(R.id.genus).text.toString()
        val family:String=findViewById<EditText>(R.id.family).text.toString()
        val order:String=findViewById<EditText>(R.id.order).text.toString()
        val carbohydrates:Double=findViewById<EditText>(R.id.carbohydrates).text.toString().toDouble()
        val protein:Double=findViewById<EditText>(R.id.protein).text.toString().toDouble()
        val fat:Double=findViewById<EditText>(R.id.fat).text.toString().toDouble()
        val calories:Long=findViewById<EditText>(R.id.calories).text.toString().toLong()
        val sugar:Double=findViewById<EditText>(R.id.sugar).text.toString().toDouble()
        fruit=Fruit(id = null,name,genus,family,order,carbohydrates,protein ,fat  ,calories,sugar )

        return fruit
    }
    fun cancel(view:View){
        this.finish()
    }
}