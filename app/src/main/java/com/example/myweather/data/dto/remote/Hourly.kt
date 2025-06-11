package com.example.myweather.data.dto.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hourly(
    @SerialName("apparent_temperature")
    val apparentTemperature: List<Double>,
    @SerialName("precipitation_probability")
    val precipitationProbability: List<Int>,
    @SerialName("relative_humidity_2m")
    val relativeHumidity2m: List<Int>,
    @SerialName("temperature_2m")
    val temperature2m: List<Double>,
    @SerialName("time")
    val time: List<String>,
    @SerialName("weather_code")
    val weatherCode: List<Int>,
    @SerialName("wind_speed_10m")
    val windSpeed10m: List<Double>
)