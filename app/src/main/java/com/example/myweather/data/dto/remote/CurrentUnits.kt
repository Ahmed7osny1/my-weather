package com.example.myweather.data.dto.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentUnits(
    @SerialName("apparent_temperature")
    val apparentTemperature: String,
    @SerialName("interval")
    val interval: String,
    @SerialName("is_day")
    val isDay: String,
    @SerialName("precipitation")
    val precipitation: String,
    @SerialName("pressure_msl")
    val pressureMsl: String,
    @SerialName("rain")
    val rain: String,
    @SerialName("relative_humidity_2m")
    val relativeHumidity2m: String,
    @SerialName("showers")
    val showers: String,
    @SerialName("temperature_2m")
    val temperature2m: String,
    @SerialName("time")
    val time: String,
    @SerialName("weather_code")
    val weatherCode: String,
    @SerialName("wind_speed_10m")
    val windSpeed10m: String
)