package com.example.myweather.domain.usecase

import com.example.myweather.domain.model.WeatherData
import com.example.myweather.domain.repository.WeatherRepository

class GetWeatherUseCase (
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(): WeatherData {
        return repository.fetchWeather()
    }
}