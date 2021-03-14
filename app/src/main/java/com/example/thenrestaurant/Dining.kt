package com.example.thenrestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dining : AppCompatActivity() {
    private  lateinit var  rv_westren : RecyclerView
    private val bdrink : ArrayList<DataFoodDetail> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dining)
        rv_westren = findViewById(R.id.list_westren)
        bdrink.addAll(data_objek.foodDetal)
        showDining()
    }
    private fun showDining(){
        rv_westren.layoutManager = GridLayoutManager(this,2)
        rv_westren.adapter = bestDrinkAdapter(bdrink)
    }
}