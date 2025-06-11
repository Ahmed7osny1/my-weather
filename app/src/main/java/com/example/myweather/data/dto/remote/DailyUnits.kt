package com.example.myweather.data.dto.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyUnits(
    @SerialName("apparent_temperature_max")
    val apparentTemperatureMax: String,
    @SerialName("apparent_temperature_min")
    val apparentTemperatureMin: String,
    @SerialName("rain_sum")
    val rainSum: String,
    @SerialName("temperature_2m_max")
    val temperature2mMax: String,
    @SerialName("temperature_2m_min")
    val temperature2mMin: String,
    @SerialName("time")
    val time: String,
    @SerialName("uv_index_max")
    val uvIndexMax: String,
    @SerialName("weather_code")
    val weatherCode: String
)