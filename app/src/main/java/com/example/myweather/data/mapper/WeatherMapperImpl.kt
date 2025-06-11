package com.example.myweather.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myweather.data.dto.remote.WeatherResponseDto
import com.example.myweather.domain.model.WeatherData
import com.example.myweather.domain.model.WeatherData.DailyWeather
import com.example.myweather.domain.model.WeatherData.HourlyWeather
import com.example.myweather.utils.WeatherCodeResource
import java.time.LocalDate
import java.time.LocalDateTime

class WeatherMapperImpl {
    @RequiresApi(Build.VERSION_CODES.O)
    fun mapToWeatherUiModel(
        response: WeatherResponseDto, cityName: String
    ): WeatherData {
        return WeatherData(
            city = cityName,
            isDay = response.current.isDay == 1,
            currentWeatherCode = response.current.weatherCode,
            temperature = response.current.temperature2m,
            weatherDescription = WeatherCodeResource.getWeatherDescription(response.current.weatherCode),
            temperatureMax = response.daily.temperature2mMax[0],
            temperatureMin = response.daily.temperature2mMin[0],
            windSpeed = response.current.windSpeed10m,
            humidity = response.current.relativeHumidity2m,
            rainChance = response.hourly.precipitationProbability[0],
            uvIndex = response.daily.uvIndexMax[0].toInt(),
            pressure = response.current.pressureMsl,
            feelsLike = response.current.apparentTemperature,
            hourlyForecast = response.hourly.time.mapIndexed { index, time ->
                HourlyWeather(
                    time = time,
                    temperature = response.hourly.temperature2m[index],
                    weatherCode = response.hourly.weatherCode[index]
                )
            }.filter { hour ->
                val hourDateTime = LocalDateTime.parse(hour.time)
                hourDateTime.hour >= LocalDateTime.now().hour && hourDateTime.toLocalDate() == LocalDate.now()
            }.take(13),
            weeklyForecast = response.daily.time.mapIndexed { index, day ->
                DailyWeather(
                    day = day,
                    temperatureMax = response.daily.temperature2mMax[index],
                    temperatureMin = response.daily.temperature2mMin[index],
                    weatherCode = response.daily.weatherCode[index]
                )
            })
    }
}
