package com.example.myweather.domain.model

data class WeatherData(
    val city: String,
    val isDay: Boolean,
    val currentWeatherCode: Int,
    val temperature: Double,
    val weatherDescription: String,
    val temperatureMax: Double,
    val temperatureMin: Double,
    val windSpeed: Double,
    val humidity: Int,
    val rainChance: Int,
    val uvIndex: Int,
    val pressure: Double,
    val feelsLike: Double,
    val hourlyForecast: List<HourlyWeather>,
    val weeklyForecast: List<DailyWeather>
) {

    data class HourlyWeather(
        val time: String,
        val temperature: Double,
        val weatherCode: Int
    )

    data class DailyWeather(
        val day: String,
        val temperatureMax: Double,
        val temperatureMin: Double,
        val weatherCode: Int
    )
}
