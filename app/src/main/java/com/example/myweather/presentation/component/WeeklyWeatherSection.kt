package com.example.myweather.presentation.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.presentation.theme.urbanist
import com.example.myweather.presentation.viewmodel.WeatherUiState
import com.example.myweather.utils.WeatherCodeResource
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeeklyWeatherCard(
    modifier: Modifier = Modifier, currentWeather: WeatherUiState
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 100.dp, max = 1000.dp)
            .background(
                currentWeather.weatherColor.cardBackgroundColor, shape = RoundedCornerShape(24.dp)
            )
            .border(
                width = 1.dp,
                currentWeather.weatherColor.cardBackgroundBorderColor,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(vertical = 4.dp)
    ) {
        val myList = currentWeather.weatherData!!.weeklyForecast

        itemsIndexed(myList) { index, step ->
            Box(contentAlignment = Alignment.BottomCenter) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = LocalDate.parse(step.day).dayOfWeek.getDisplayName(
                            TextStyle.FULL, Locale.ENGLISH
                        ),
                        modifier = Modifier.width(91.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = urbanist,
                        letterSpacing = 0.25.sp,
                        color = currentWeather.weatherColor.textSubTitleColor,
                    )
                    Image(
                        painter = painterResource(
                            WeatherCodeResource.getWeatherImage(
                                weatherCode = step.weatherCode, isDay = currentWeather.isDay
                            )
                        ), contentDescription = "Weather Icon", modifier = Modifier.size(48.dp)
                    )
                    Row(
                        modifier = Modifier.width(110.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_arrow_up),
                                contentDescription = null,
                                tint = currentWeather.weatherColor.cardContentAboveColor,
                            )
                            Text(
                                text = "${step.temperatureMax.toInt()}°C",
                                color = currentWeather.weatherColor.cardContentAboveColor,
                                fontFamily = urbanist,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                letterSpacing = 0.25.sp,
                            )
                        }

                        Box(
                            modifier = Modifier
                                .height(14.dp)
                                .width(1.dp)
                                .border(
                                    width = 1.dp,
                                    color = currentWeather.weatherColor.cardBackgroundBorderColor
                                )
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_arrow_down),
                                contentDescription = null,
                                tint = currentWeather.weatherColor.cardContentAboveColor
                            )
                            Text(
                                text = "${step.temperatureMin.toInt()}°C",
                                color = currentWeather.weatherColor.cardContentAboveColor,
                                fontFamily = urbanist,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                letterSpacing = 0.25.sp,
                            )
                        }
                    }
                }
                if (index != myList.lastIndex) {
                    HorizontalDivider(
                        color = currentWeather.weatherColor.cardBackgroundBorderColor
                    )
                }
            }
        }
    }
}
