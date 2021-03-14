package com.example.thenrestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserProfile : AppCompatActivity() {

    private lateinit var username : TextView
    private lateinit var phone : TextView
    private lateinit var alergic : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        username = findViewById(R.id.user_name)
        phone = findViewById(R.id.user_phone_number)
        alergic = findViewById(R.id.user_alergic)

        username.text = "Anna Karenina Jusuf"
        phone.text = "0987654321"
        alergic.text = "Food alergic : Shrimp"

    }
}


