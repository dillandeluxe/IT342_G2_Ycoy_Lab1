package com.ycoy.userauthmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ycoy.userauthmobile.api.LoginRequest
import com.ycoy.userauthmobile.api.RetrofitClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sessionManager = SessionManager(this)

        // AUTO-LOGIN: If a token already exists, skip straight to the Dashboard
        if (sessionManager.fetchAuthToken() != null) {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
            return
        }

        setContentView(R.layout.activity_main)

        // Connect to the UI elements
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvGoToRegister = findViewById<TextView>(R.id.tvGoToRegister) // ADDED THIS

        // Go to Register Screen when text is clicked
        tvGoToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Handle Login button click
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Basic Validation
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Perform the Login Network Call
            lifecycleScope.launch {
                try {
                    val response = RetrofitClient.instance.login(LoginRequest(email, password))

                    if (response.isSuccessful && response.body() != null) {
                        val loginResponse = response.body()!!

                        // 1. SAVE THE JWT TOKEN
                        sessionManager.saveAuthToken(loginResponse.token, loginResponse.username)

                        Toast.makeText(this@MainActivity, "Login Success!", Toast.LENGTH_SHORT).show()

                        // 2. NAVIGATE TO DASHBOARD
                        startActivity(Intent(this@MainActivity, DashboardActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@MainActivity, "Failed: Invalid credentials", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, "Network Error: Is the backend running?", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }
        }
    }
}