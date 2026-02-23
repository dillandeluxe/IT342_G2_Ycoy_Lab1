package com.ycoy.userauthmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ycoy.userauthmobile.api.RegisterRequest
import com.ycoy.userauthmobile.api.RetrofitClient
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etFirstName = findViewById<EditText>(R.id.etRegFirstName)
        val etLastName = findViewById<EditText>(R.id.etRegLastName)
        val etUsername = findViewById<EditText>(R.id.etRegUsername)
        val etEmail = findViewById<EditText>(R.id.etRegEmail)
        val etPassword = findViewById<EditText>(R.id.etRegPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvGoToLogin = findViewById<TextView>(R.id.tvGoToLogin)

        // Navigate back to Login if they click the text
        tvGoToLogin.setOnClickListener {
            finish() // Closes the register screen, revealing the login screen underneath
        }

        btnRegister.setOnClickListener {
            val fName = etFirstName.text.toString().trim()
            val lName = etLastName.text.toString().trim()
            val uName = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val pass = etPassword.text.toString().trim()

            // Basic Validation
            if (fName.isEmpty() || lName.isEmpty() || uName.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Perform Network Call
            lifecycleScope.launch {
                try {
                    val request = RegisterRequest(fName, lName, uName, email, pass)
                    val response = RetrofitClient.instance.register(request)

                    if (response.isSuccessful) {
                        Toast.makeText(this@RegisterActivity, "Registration Successful!", Toast.LENGTH_LONG).show()
                        finish() // Return to Login screen
                    } else {
                        // Backend returns a 400 Bad Request if email exists
                        Toast.makeText(this@RegisterActivity, "Registration Failed: Email may be in use", Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@RegisterActivity, "Network Error", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }
        }
    }
}