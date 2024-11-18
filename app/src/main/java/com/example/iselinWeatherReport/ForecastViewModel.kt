package com.example.iselinWeatherReport

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class ViewState(
    val temperature: Float? = null,
    val weatherDescription: String? = null,
    val humidity: Float? = null,
    val windSpeed: Float? = null
)

class ForecastViewModel(
    private val locationForecastService: LocationForecastService
) : ViewModel() {
    private val _viewState = MutableStateFlow(ViewState())
    val viewState: StateFlow<ViewState>
        get() = _viewState.stateIn(
            scope = viewModelScope,
            started = WhileSubscribed(5000),
            initialValue = ViewState()
        )

    init {
        fetchCurrentWeather()
    }

    private fun fetchCurrentWeather() {
        viewModelScope.launch {
            val response = locationForecastService.getHardcodedLocation(lat = 60.0f, lon = 11.0f)
            val temperature = response.body()?.properties?.timeSeries?.firstOrNull()?.data?.instant?.details
                ?.airTemperature
            _viewState.getAndUpdate { viewState -> viewState.copy(temperature = temperature) }
        }
    }
}