package com.example.iselinWeatherReport

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface LocationForecastService {
    @Headers("User-Agent: IselinWeatherReport github.com/iselinsilvana")
    @GET("weatherapi/locationforecast/2.0/compact")
    suspend fun getHardcodedLocation(@Query("lat") lat: Float, @Query("lon") lon: Float): Response<Forecast>

    @Headers("User-Agent: IselinWeatherReport github.com/iselinsilvana")
    @GET("weatherapi/locationforecast/2.0/healthz")
    suspend fun healthz(): Response<Any?>
}