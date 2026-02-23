package com.ycoy.userauthmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ycoy.userauthmobile.api.RetrofitClient
import kotlinx.coroutines.launch

class DashboardActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        sessionManager = SessionManager(this)

        // PROTECTED ROUTE CHECK: If no token exists, kick back to Login
        if (sessionManager.fetchAuthToken() == null) {
            navigateToLogin()
            return
        }

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Show the username that we saved during login
        tvWelcome.text = "Welcome, ${sessionManager.fetchUsername()}!"

        // Handle Logout
        btnLogout.setOnClickListener {
            performLogout()
        }
        val btnProfile = findViewById<Button>(R.id.btnProfile)

        // Open the Profile Activity
        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    private fun performLogout() {
        lifecycleScope.launch {
            try {
                // Optional: Tell the backend we are logging out
                RetrofitClient.instance.logout()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                // Delete the token from the phone's memory
                sessionManager.logout()
                Toast.makeText(this@DashboardActivity, "Logged out", Toast.LENGTH_SHORT).show()
                navigateToLogin()
            }
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, MainActivity::class.java)
        // This clears the backstack so the user can't just press the "Back" button to return to the dashboard
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}