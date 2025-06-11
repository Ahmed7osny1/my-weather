package com.example.myweather.data.dto.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyUnits(
    @SerialName("apparent_temperature")
    val apparentTemperature: String,
    @SerialName("precipitation_probability")
    val precipitationProbability: String,
    @SerialName("relative_humidity_2m")
    val relativeHumidity2m: String,
    @SerialName("temperature_2m")
    val temperature2m: String,
    @SerialName("time")
    val time: String,
    @SerialName("weather_code")
    val weatherCode: String,
    @SerialName("wind_speed_10m")
    val windSpeed10m: String
)