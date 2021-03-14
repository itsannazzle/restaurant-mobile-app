package com.example.thenrestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class newMenuAdapter(private val menu : ArrayList<DataNewMenu>) : RecyclerView.Adapter<newMenuAdapter.menuViewHolder>() {
    inner class menuViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView = itemView.findViewById(R.id.food_title)
        var price : TextView = itemView.findViewById(R.id.price)
        var food_time: TextView = itemView.findViewById(R.id.times)
        var food_origin : TextView = itemView.findViewById(R.id.food_origin)
        var food_rating : TextView = itemView.findViewById(R.id.rating)
        var food_image : ImageView = itemView.findViewById(R.id.imageView3)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): newMenuAdapter.menuViewHolder {
        val view :  View = LayoutInflater.from(parent.context).inflate(R.layout.new_menu,parent,false)
        return menuViewHolder(view)
    }

    override fun onBindViewHolder(holder: newMenuAdapter.menuViewHolder, position: Int) {
        val m = menu[position]
        holder.name.text = m.food_name
        holder.price.text = m.food_price
        holder.food_time.text = m.food_time
        holder.food_origin.text = m.food_loc
        holder.food_rating.text = m.food_rating.toString()
        Glide.with(holder.itemView).load(m.food_img).into(holder.food_image)
    }

    override fun getItemCount(): Int {
        return  menu.size
    }
}