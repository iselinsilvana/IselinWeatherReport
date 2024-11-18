package com.example.iselinWeatherReport

import com.google.gson.annotations.SerializedName
import com.google.maps.android.data.geojson.GeoJsonPoint

data class Forecast(
    val geometry: GeoJsonPoint,
    val properties: ForecastTimeSeries,
    val type: Type
)

data class ForecastTimeSeries(
    val meta: Meta,
    @SerializedName("timeseries")
    val timeSeries: List<TimeSpecificForecast>
)

enum class Type{
    FEATURE
}

data class Meta(
    val units: ForecastUnits,
    @SerializedName("updated_at")
    val updatedAt: String
)

data class TimeSpecificForecast(
    val data: TimeSeries,
    val time: String
)

data class ForecastUnits(
    @SerializedName("air_temperature")
    val airTemperature: String? = null,
    @SerializedName("relative_humidity")
    val relativeHumidity: String? = null,
    @SerializedName("wind_speed")
    val windSpeed: String? = null
)

data class TimeSeries(
    val instant: ForecastTimeInstant? = null,
    @SerializedName("next_12_hours")
    val next12Hours: TimePeriod
)

data class ForecastTimeInstant(
    val details: Details
)

data class Details(
    @SerializedName("air_temperature")
    val airTemperature: Float? = null,
    @SerializedName("relative_humidity")
    val relativeHumidity: Float? = null,
    @SerializedName("wind_speed")
    val windSpeed: Float? = null
)

data class TimePeriod(
    val details: ForecastTimePeriod? = null,
    val summary: ForecastSummary
)

data class ForecastTimePeriod(
    @SerializedName("air_temperature_max")
    val airTemperatureMax: Float? = null,
    @SerializedName("air_temperature_min")
    val airTemperatureMin: Float? = null,
    @SerializedName("precipitation_amount")
    val precipitationAmount: Float? = null
)

data class ForecastSummary(
    @SerializedName("symbol_code")
    val symbolCode: SymbolCode
)

enum class SymbolCode {
    clearsky_day,
    clearsky_night,
    clearsky_polartwilight,
    fair_day,
    fair_night,
    fair_polartwilight,
    lightssnowshowersandthunder_day,
    lightssnowshowersandthunder_night,
    lightssnowshowersandthunder_polartwilight,
    lightsnowshowers_day,
    lightsnowshowers_night,
    lightsnowshowers_polartwilight,
    heavyrainandthunder,
    heavysnowandthunder,
    rainandthunder,
    heavysleetshowersandthunder_day,
    heavysleetshowersandthunder_night,
    heavysleetshowersandthunder_polartwilight,
    heavysnow,
    heavyrainshowers_day,
    heavyrainshowers_night,
    heavyrainshowers_polartwilight,
    lightsleet,
    heavyrain,
    lightrainshowers_day,
    lightrainshowers_night,
    lightrainshowers_polartwilight,
    heavysleetshowers_day,
    heavysleetshowers_night,
    heavysleetshowers_polartwilight,
    lightsleetshowers_day,
    lightsleetshowers_night,
    lightsleetshowers_polartwilight,
    snow,
    heavyrainshowersandthunder_day,
    heavyrainshowersandthunder_night,
    heavyrainshowersandthunder_polartwilight,
    snowshowers_day,
    snowshowers_night,
    snowshowers_polartwilight,
    fog,
    snowshowersandthunder_day,
    snowshowersandthunder_night,
    snowshowersandthunder_polartwilight,
    lightsnowandthunder,
    heavysleetandthunder,
    lightrain,
    rainshowersandthunder_day,
    rainshowersandthunder_night,
    rainshowersandthunder_polartwilight,
    rain,
    lightsnow,
    lightrainshowersandthunder_day,
    lightrainshowersandthunder_night,
    lightrainshowersandthunder_polartwilight,
    heavysleet,
    sleetandthunder,
    lightrainandthunder,
    sleet,
    lightssleetshowersandthunder_day,
    lightssleetshowersandthunder_night,
    lightssleetshowersandthunder_polartwilight,
    lightsleetandthunder,
    partlycloudy_day,
    partlycloudy_night,
    partlycloudy_polartwilight,
    sleetshowersandthunder_day,
    sleetshowersandthunder_night,
    sleetshowersandthunder_polartwilight,
    rainshowers_day,
    rainshowers_night,
    rainshowers_polartwilight,
    snowandthunder,
    sleetshowers_day,
    sleetshowers_night,
    sleetshowers_polartwilight,
    cloudy,
    heavysnowshowersandthunder_day,
    heavysnowshowersandthunder_night,
    heavysnowshowersandthunder_polartwilight,
    heavysnowshowers_day,
    heavysnowshowers_night,
    heavysnowshowers_polartwilight
}