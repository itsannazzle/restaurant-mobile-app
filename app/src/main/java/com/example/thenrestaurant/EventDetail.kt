package com.example.thenrestaurant

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class EventDetail : AppCompatActivity(), View.OnClickListener {
    private lateinit var spotify : TextView
    companion object{
        const val EXTRA_ARTIST = "extra_age"
        const val EXTRA_DATE = "Anna"
        const val EXTRA_DESC = "jj"
        const val EXTRA_IMG = "0"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)
        spotify = findViewById(R.id.detail_spotify)

        val art = findViewById<TextView>(R.id.detail_title)
        val desc = findViewById<TextView>(R.id.detail_content)
        val performdate = findViewById<TextView>(R.id.event_date)
        val img = findViewById<ImageView>(R.id.detail_image)

        art.text = intent.getStringExtra(EXTRA_ARTIST)
        desc.text = intent.getStringExtra(EXTRA_DESC)
        performdate.text = intent.getStringExtra(EXTRA_DATE)
        intent.extras?.let { img.setImageResource(it.getInt(EXTRA_IMG)) }

        spotify.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            spotify -> {
                Toast.makeText(this,"Supposed to open spotify but later",Toast.LENGTH_LONG).show()
            }
        }
    }
}


