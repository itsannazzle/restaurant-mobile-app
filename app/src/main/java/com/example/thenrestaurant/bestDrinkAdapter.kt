package com.example.thenrestaurant

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.security.PrivateKey

class bestDrinkAdapter(private val best : ArrayList<DataFoodDetail>) : RecyclerView.Adapter<bestDrinkAdapter.drinkViewHolder>() {

    inner class drinkViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var name : TextView = itemView.findViewById(R.id.food_title)
        var price : TextView = itemView.findViewById(R.id.price)
        var food_time: TextView = itemView.findViewById(R.id.times)
        var food_origin : TextView = itemView.findViewById(R.id.food_origin)
        var food_rating : TextView = itemView.findViewById(R.id.rating)
        var food_image : ImageView = itemView.findViewById(R.id.imageView4)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): bestDrinkAdapter.drinkViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.best_seller_drinks,parent,false)
        return drinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: bestDrinkAdapter.drinkViewHolder, position: Int) {
        val dr = best[position]
        holder.name.text = dr.food_name
        holder.price.text = dr.food_price
        holder.food_time.text = dr.food_time
        holder.food_origin.text = dr.food_loc
        holder.food_rating.text = dr.food_rating.toString()
        Glide.with(holder.itemView).load(dr.food_img).into(holder.food_image)
        holder.itemView.setOnClickListener {
            var passingData =  Intent(holder.itemView.context,Food_detail::class.java)
            passingData.putExtra(Food_detail.EXTRA_TITLE,best[holder.adapterPosition].food_name)
            passingData.putExtra(Food_detail.EXTRA_PRICE,best[holder.adapterPosition].food_price)
            passingData.putExtra(Food_detail.EXTRA_TIME,best[holder.adapterPosition].food_time)
            passingData.putExtra(Food_detail.EXTRA_RATING,best[holder.adapterPosition].food_rating)
            passingData.putExtra(Food_detail.EXTRA_DESC,best[holder.adapterPosition].food_desc)
            passingData.putExtra(Food_detail.EXTRA_ALERGIC,best[holder.adapterPosition].food_alergic)
            passingData.putExtra(Food_detail.EXTRA_IMG,best[holder.adapterPosition].food_img)
            holder.itemView.context.startActivity(passingData)
        }
    }

    override fun getItemCount(): Int {
       return best.size
    }
}