package com.example.iselinWeatherReport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.iselinWeatherReport.ui.theme.IselinWeatherReportTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    private val viewModel: ForecastViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            IselinWeatherReportTheme {
                val state: ViewState by viewModel.viewState.collectAsState()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
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
    Text(
        text = "Current temperature is ${state.temperature}",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IselinWeatherReportTheme {
        Greeting(state = ViewState(temperature = 20.0f))
    }
}
