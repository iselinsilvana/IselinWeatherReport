package com.example.iselinWeatherReport

import com.google.maps.android.data.geojson.GeoJsonPoint

data class Forecast(
    val geometry: GeoJsonPoint? = null,
    val properties: Any? = null,
    val type: String = ""
)