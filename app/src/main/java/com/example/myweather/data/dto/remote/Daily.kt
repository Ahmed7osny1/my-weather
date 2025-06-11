package com.example.myweather.data.dto.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    @SerialName("apparent_temperature_max")
    val apparentTemperatureMax: List<Double>,
    @SerialName("apparent_temperature_min")
    val apparentTemperatureMin: List<Double>,
    @SerialName("rain_sum")
    val rainSum: List<Double>,
    @SerialName("temperature_2m_max")
    val temperature2mMax: List<Double>,
    @SerialName("temperature_2m_min")
    val temperature2mMin: List<Double>,
    @SerialName("time")
    val time: List<String>,
    @SerialName("uv_index_max")
    val uvIndexMax: List<Double>,
    @SerialName("weather_code")
    val weatherCode: List<Int>
)