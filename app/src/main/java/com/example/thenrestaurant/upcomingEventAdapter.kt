package com.example.thenrestaurant

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class upcomingEventAdapter(private val event : ArrayList<DataUpcomingEvent>) : RecyclerView.Adapter<upcomingEventAdapter.viewHolder>() {
    inner class viewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var artist : TextView = itemView.findViewById(R.id.event_artist)
        var date : TextView = itemView.findViewById(R.id.event_date)
        var banner : ImageView = itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): upcomingEventAdapter.viewHolder {
       val view : View = LayoutInflater.from(parent.context)
           .inflate(R.layout.upcoming_event,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: upcomingEventAdapter.viewHolder, position: Int) {
        val p = event[position]
        holder.artist.text = p.artist_name
        holder.date.text = p.perform_date
        Glide.with(holder.itemView).load(p.banner_img).into(holder.banner)
        holder.itemView.setOnClickListener {
            val passingData =  Intent(holder.itemView.context,EventDetail::class.java)
            passingData.putExtra(EventDetail.EXTRA_ARTIST,event[holder.adapterPosition].artist_name)
            passingData.putExtra(EventDetail.EXTRA_DATE,event[holder.adapterPosition].perform_date)
            passingData.putExtra(EventDetail.EXTRA_DESC,event[holder.adapterPosition].detail)
            passingData.putExtra(EventDetail.EXTRA_IMG,event[holder.adapterPosition].banner_img)
            holder.itemView.context.startActivity(passingData)
        }
    }

    override fun getItemCount(): Int {
        return event.size
    }
}