package com.example.iselinWeatherReport

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val logging = HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BASIC) }
    private val client = OkHttpClient.Builder().addInterceptor(logging).build()
    val locationForecastService: LocationForecastService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.met.no/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LocationForecastService::class.java)
    }
}