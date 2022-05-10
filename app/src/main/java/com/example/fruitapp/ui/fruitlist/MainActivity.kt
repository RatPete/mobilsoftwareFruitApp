package com.example.fruitapp.ui.fruitlist

import android.R.id
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitapp.R
import com.example.fruitapp.ui.fruitadd.AddActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val fruitsViewModel: MainViewModel by viewModels()
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    lateinit var fruitAdapter: FruitAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecylcerView()

        firebaseAnalytics = Firebase.analytics
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "asd")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "asd2")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        val crashButton = Button(this)
        crashButton.text = "Test Crash"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

        addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT))

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
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "addItem")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Adding an item to the list")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Text")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        view.context.startActivity(intent)

    }

}