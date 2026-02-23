package com.ycoy.userauthmobile.api

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    // 1. Login endpoint (Returns the JSON with the token)
    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    // 2. Register endpoint (Returns plain text)
    @POST("api/auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<ResponseBody>

    // 3. Logout endpoint (Returns plain text)
    @POST("api/auth/logout")
    suspend fun logout(): Response<ResponseBody>
}