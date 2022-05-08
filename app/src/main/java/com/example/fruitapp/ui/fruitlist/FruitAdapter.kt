package com.example.fruitapp.ui.fruitlist
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitapp.R
import com.example.fruitapp.databinding.FruitRowBinding
import com.example.fruitapp.presmodels.Fruit
import com.example.fruitapp.ui.fruitdetails.DetailsActivity
import com.example.fruitapp.ui.fruitedit.EditActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FruitAdapter(private val context: Context, private val fruitsViewModel:MainViewModel):ListAdapter<Fruit, FruitAdapter.FruitViewHolder>(FruitComparator){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val binding: FruitRowBinding =DataBindingUtil.inflate(layoutInflater,R.layout.fruit_row,parent,false)
        binding.adapter=this
        return FruitViewHolder(binding)
    }
    var fruits= mutableListOf<Fruit>()

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit =getItem(position)
        holder.bind(fruit)
    }
    fun deleteFruit(fruit:Fruit){
        fruitsViewModel.DeleteFruit(fruit)
        fruitsViewModel.UpdateAdapter(this)
    }
    fun showDetails(fruit:Fruit){
        val intent = Intent(context,DetailsActivity::class.java)
        intent.putExtra("fruit",fruit.id)
        context.startActivity(intent)
    }
    class FruitViewHolder(val binding: FruitRowBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(fruit:Fruit){
            binding.fruit=fruit
        }
    }
    fun editFruit(fruit:Fruit){
        val intent=Intent(context,EditActivity::class.java)
        intent.putExtra("fruit",fruit.id)
        context.startActivity(intent)
    }

}