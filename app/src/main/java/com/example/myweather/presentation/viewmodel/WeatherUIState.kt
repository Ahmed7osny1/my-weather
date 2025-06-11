package com.example.myweather.presentation.viewmodel

import com.example.myweather.R
import com.example.myweather.domain.model.WeatherData
import com.example.myweather.utils.WeatherAppColors
import com.example.myweather.utils.WeatherAppDarkColors

data class WeatherUiState(
    val isLoading: Boolean = false,
    val weatherData: WeatherData? = null,
    val weatherColor: WeatherAppColors = WeatherAppDarkColors,
    val weatherImage: Int = R.drawable.weather_80_day,
    val isDay: Boolean = true,
    val error: String? = null
)
