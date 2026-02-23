package com.ycoy.userauthmobile

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    // This creates a private file on the phone called "AuthPrefs" to store our data
    private var prefs: SharedPreferences = context.getSharedPreferences("AuthPrefs", Context.MODE_PRIVATE)

    // Save the token and username after a successful login
    fun saveAuthToken(token: String, username: String) {
        val editor = prefs.edit()
        editor.putString("JWT_TOKEN", token)
        editor.putString("USERNAME", username)
        editor.apply()
    }

    // Retrieve the token to check if the user is logged in
    fun fetchAuthToken(): String? {
        return prefs.getString("JWT_TOKEN", null)
    }

    // Retrieve the username to show on the Dashboard
    fun fetchUsername(): String? {
        return prefs.getString("USERNAME", "User")
    }

    // Delete everything when the user logs out
    fun logout() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}