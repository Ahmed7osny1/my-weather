package com.example.myweather.presentation.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.domain.model.WeatherData.HourlyWeather
import com.example.myweather.presentation.theme.NightSmallBlurColor
import com.example.myweather.presentation.theme.SmallBlurColor
import com.example.myweather.presentation.theme.urbanist
import com.example.myweather.presentation.viewmodel.WeatherUiState
import com.example.myweather.utils.WeatherCodeResource

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HourlyWeatherChip(
    currentWeather: WeatherUiState, forecastDataItem: HourlyWeather
) {
    Box(
        modifier = Modifier.height(135.dp)
    ) {
        Column(
            modifier = Modifier
                .size(88.dp, 120.dp)
                .align(Alignment.BottomCenter)
                .background(
                    color = currentWeather.weatherColor.cardBackgroundColor,
                    shape = RoundedCornerShape(20.dp)
                )
                .border(
                    width = 1.dp,
                    color = currentWeather.weatherColor.cardBackgroundBorderColor,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${forecastDataItem.temperature.toInt()}°C",
                color = currentWeather.weatherColor.cardContentColor,
                fontFamily = urbanist,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                letterSpacing = 0.25.sp
            )
            Spacer(Modifier.width(4.dp))
            Text(
                text = forecastDataItem.time.substring(11, 16),
                color = currentWeather.weatherColor.cardSubContentColor,
                fontFamily = urbanist,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                letterSpacing = 0.25.sp
            )
        }

        Image(
            painter = painterResource(
                WeatherCodeResource.getWeatherImage(
                        weatherCode = forecastDataItem.weatherCode, isDay = currentWeather.isDay
                    )
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp, 58.dp)
                .align(Alignment.TopCenter)
                .dropShadow(
                    color = if (currentWeather.isDay) SmallBlurColor
                    else NightSmallBlurColor,
                    blur = 24.dp,
                )
        )
    }
}