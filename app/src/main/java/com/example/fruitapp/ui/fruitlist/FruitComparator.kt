package com.example.fruitapp.ui.fruitlist

import androidx.recyclerview.widget.DiffUtil
import com.example.fruitapp.presmodels.Fruit

object FruitComparator: DiffUtil.ItemCallback<Fruit>() {
    override fun areItemsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
        return oldItem.name==newItem.name
    }

    override fun areContentsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
        return oldItem==newItem
    }
}