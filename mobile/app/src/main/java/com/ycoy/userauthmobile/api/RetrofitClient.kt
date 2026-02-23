package com.ycoy.userauthmobile.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // 10.0.2.2 is the special IP that allows the Android Emulator to talk to your computer's localhost:8080
    private const val BASE_URL = "http://10.0.2.2:8080/"

    val instance: AuthService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Converts JSON to Kotlin objects
            .build()
            .create(AuthService::class.java)
    }
}