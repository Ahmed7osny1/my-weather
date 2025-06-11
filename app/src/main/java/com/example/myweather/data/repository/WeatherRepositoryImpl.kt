package com.example.myweather.data.repository

import android.os.Build
import android.util.Log
import android.util.Log.e
import androidx.annotation.RequiresApi
import com.example.myweather.data.dto.remote.WeatherResponseDto
import com.example.myweather.data.mapper.WeatherMapperImpl
import com.example.myweather.data.service.LocationProvider
import com.example.myweather.domain.model.WeatherData
import com.example.myweather.domain.repository.WeatherRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl(
    private val client: HttpClient,
    private val weatherMapper: WeatherMapperImpl,
    private val locationProvider: LocationProvider,
) : WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun fetchWeather(): WeatherData {
        val userLocation = locationProvider.getUserLocation() ?: throw Exception("User location is null")

        return withContext(Dispatchers.IO) {
            try {
                val response: WeatherResponseDto =
                    client.get("https://api.open-meteo.com/v1/forecast") {
                        parameter("latitude", userLocation.latitude)
                        parameter("longitude", userLocation.longitude)
                        parameter(
                            "daily",
                            "weather_code,rain_sum,temperature_2m_max,temperature_2m_min,uv_index_max,apparent_temperature_max,apparent_temperature_min"
                        )
                        parameter(
                            "hourly",
                            "temperature_2m,weather_code,relative_humidity_2m,wind_speed_10m,apparent_temperature,precipitation_probability"
                        )
                        parameter(
                            "current",
                            "temperature_2m,weather_code,wind_speed_10m,relative_humidity_2m,apparent_temperature,is_day,precipitation,rain,showers,pressure_msl"
                        )

                    }.body()
                Log.d("WeatherRepository", "$response")
                weatherMapper.mapToWeatherUiModel(response, userLocation.cityName)
            } catch (e: Exception) {
                e("WeatherRepository", "API Error: ${e.message}")
                throw Exception("Error fetching weather data: ${e.message}")
            }
        }
    }

}
