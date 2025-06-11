package com.example.myweather.domain.repository

import com.example.myweather.domain.model.WeatherData

interface WeatherRepository {
    suspend fun fetchWeather(): WeatherData
}