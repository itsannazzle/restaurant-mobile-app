package com.example.thenrestaurant

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Food_detail : AppCompatActivity() {
    private lateinit var rv_wine : RecyclerView
    private val winewine : ArrayList<DataFoodDetail> = arrayListOf()
    companion object{
        const val EXTRA_TITLE = "TITLE"
        const val EXTRA_PRICE = "PRICE"
        const val EXTRA_TIME = "10M"
        const val EXTRA_RATING = "1.0"
        const val EXTRA_DESC = "DESC"
        const val EXTRA_ALERGIC = "ALERGIC"
        const val EXTRA_IMG = "0"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        val title = findViewById<TextView>(R.id.food_title)
        val desc = findViewById<TextView>(R.id.text_desc)
        val price = findViewById<TextView>(R.id.price)
        val dtime = findViewById<TextView>(R.id.ddtime)
        val alergic = findViewById<TextView>(R.id.alerg_desc)
        val img = findViewById<ImageView>(R.id.food_image)
        val rating = findViewById<TextView>(R.id.rating)
        rv_wine = findViewById(R.id.rv_wine)

        title.text = intent.getStringExtra(EXTRA_TITLE)
        desc.text = intent.getStringExtra(EXTRA_DESC)
        price.text = intent.getStringExtra(EXTRA_PRICE)
        dtime.text = intent.getStringExtra(EXTRA_TIME)
        alergic.text = intent.getStringExtra(EXTRA_ALERGIC)
        rating.text = intent.getDoubleExtra(EXTRA_RATING,0.3).toString()
        intent.extras?.let { img.setImageResource(it.getInt(EXTRA_IMG)) }


        winewine.addAll(data_objek.bestwine)
        showBestDrink()
    }

    private fun showBestDrink(){
        rv_wine.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_wine.adapter = bestDrinkAdapter(winewine)
    }
}