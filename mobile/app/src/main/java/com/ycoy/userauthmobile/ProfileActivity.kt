package com.ycoy.userauthmobile

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sessionManager = SessionManager(this)

        val tvProfileUsername = findViewById<TextView>(R.id.tvProfileUsername)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Fetch the username from memory and display it
        val username = sessionManager.fetchUsername()
        tvProfileUsername.text = "Username: $username"

        // Make the back button close this screen
        btnBack.setOnClickListener {
            finish()
        }
    }
}