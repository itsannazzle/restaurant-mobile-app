package com.example.thenrestaurant

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener,
    BottomNavigationView.OnNavigationItemReselectedListener {
    private lateinit var rv_event : RecyclerView
    private lateinit var rv_categoty : RecyclerView
    private lateinit var rv_newMenu : RecyclerView
    private lateinit var rv_best_drink : RecyclerView
    private val event : ArrayList<DataUpcomingEvent> = arrayListOf()
    private val category : ArrayList<DataBeverage> = arrayListOf()
    private val newM : ArrayList<DataNewMenu> = arrayListOf()
    private val bdrink : ArrayList<DataFoodDetail> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nav_bottom : BottomNavigationView = findViewById(R.id.nav_bottom)
        nav_bottom.setOnNavigationItemReselectedListener(this)
        rv_event = findViewById(R.id.rv_event)
        rv_categoty = findViewById(R.id.rv_category)
        rv_newMenu = findViewById(R.id.rv_new_menu)
        rv_best_drink = findViewById(R.id.rv_bestseller_drink)

        event.addAll(data_objek.upcomingEvent)
        category.addAll(data_objek.cat)
        newM.addAll(data_objek.newwMenu)
        bdrink.addAll(data_objek.bestDrink)

        showUpcomingEvent()
        showCategory()
        showNewMenu()
        showBestDrink()

    }

    private fun showUpcomingEvent(){
        rv_event.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_event.adapter = upcomingEventAdapter(event)
    }

    private fun showCategory(){
        rv_categoty.layoutManager = LinearLayoutManager(this)
        rv_categoty.adapter = categoryAdapter(category)
    }

    private fun showNewMenu(){
        rv_newMenu.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_newMenu.adapter = newMenuAdapter(newM)
    }
    private fun showBestDrink(){
        rv_best_drink.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_best_drink.adapter = bestDrinkAdapter(bdrink)
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this,EventDetail::class.java))
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        when(item.itemId){
            R.id.action_profile -> {
                startActivity(Intent(this,UserProfile::class.java))
            }
        }
    }


}