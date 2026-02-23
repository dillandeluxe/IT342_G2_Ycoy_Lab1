package com.ycoy.userauthmobile.api


data class LoginResponse(
    val message: String,
    val token: String,
    val email: String,
    val username: String
)
