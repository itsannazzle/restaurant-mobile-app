package com.example.thenrestaurant

import android.media.Image
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.thenrestaurant.databinding.ActivityEventDetailBinding
import org.w3c.dom.Text

class EventDetail : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityEventDetailBinding
    private lateinit var spotify : TextView
    companion object{
        const val EXTRA_ARTIST = "extra_age"
        const val EXTRA_DATE = "Anna"
        const val EXTRA_DESC = "jj"
        const val EXTRA_IMG = "0"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

        setIconEnable()

        binding.myEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setIconEnable()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        binding.myButton.setOnClickListener(this)
    }
    private fun setIconEnable(){
        binding.myButton.isEnabled = binding.myEditText.text != null && binding.myEditText.text.toString().isNotEmpty()

    }
    override fun onClick(v: View?) {
        when(v){
            spotify -> {
                Toast.makeText(this,"Supposed to open spotify but later",Toast.LENGTH_LONG).show()
            }
            binding.myButton -> {
                Toast.makeText(this,binding.myEditText.text,Toast.LENGTH_LONG).show()
            }
        }
    }
}


