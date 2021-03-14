package com.example.thenrestaurant

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class categoryAdapter(private val cat : ArrayList<DataBeverage>) : RecyclerView.Adapter<categoryAdapter.catViewHolder>() {
    inner class catViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var category : TextView = itemView.findViewById(R.id.category)
        var banner : ImageView = itemView.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): categoryAdapter.catViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.category,parent,false)
        return catViewHolder(view)
    }

    override fun onBindViewHolder(holder: categoryAdapter.catViewHolder, position: Int) {
       val c = cat[position]
        holder.category.text = c.dining_category
        Glide.with(holder.itemView).load(c.banner_cat).into(holder.banner)
        holder.itemView.setOnClickListener {
            val passingData =  Intent(holder.itemView.context,Dining::class.java)
            passingData.let { cat[holder.adapterPosition].dining_category }
            holder.itemView.context.startActivity(passingData)
        }
    }

    override fun getItemCount(): Int {
        return cat.size
    }
}