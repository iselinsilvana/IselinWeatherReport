package com.example.iselinWeatherReport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.iselinWeatherReport.ui.theme.IselinWeatherReportTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: ForecastViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            IselinWeatherReportTheme {
                val state: ViewState by viewModel.viewState.collectAsState()
                Scaffold(modifier = Modifier) { innerPadding ->
                    Greeting(
                        state = state,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(state: ViewState, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Current temperature is ${state.temperature}"
        )
        Text(
            text = "Humidity is ${state.humidity}"
        )
        Text(
            text = "Wind speed is ${state.windSpeed}"
        )
        Text(
            text = "This is a ${state.weatherDescription}"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IselinWeatherReportTheme {
        Greeting(
            state = ViewState(
                temperature = 20.0f,
                humidity = 98.0f,
                windSpeed = 5.0f,
                weatherDescription = SymbolCode.partlycloudy_day
            )
        )
    }
}
