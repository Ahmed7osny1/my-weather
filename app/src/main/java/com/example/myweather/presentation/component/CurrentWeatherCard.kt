package com.example.myweather.presentation.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.myweather.R
import com.example.myweather.presentation.theme.urbanist
import com.example.myweather.presentation.viewmodel.WeatherUiState

@Composable
fun CurrentWeatherCard(
    currentWeather: WeatherUiState,
    scrollState: ScrollState,
) {

    val rawScroll = scrollState.value.toFloat()
    val maxScrollPx = 120f
    val scrollProgress = (rawScroll / maxScrollPx).coerceIn(0f, 1f)

    val imageHeight = lerp(200.dp, 112.dp, scrollProgress)
    val imageWidth = lerp(220.dp, 124.dp, scrollProgress)

    val easedScrollProgress = scrollProgress.coerceIn(0f, 1f)
    val animatedHeight by animateDpAsState(
        targetValue = lerp(355.dp, 143.dp, easedScrollProgress),
    )
    val weatherImageTargetAlignment =
        if (easedScrollProgress < 0.4f) Alignment.TopCenter else Alignment.CenterStart

    val currentWeatherDetailsTargetAlignment =
        if (easedScrollProgress < 0.4f) Alignment.BottomCenter else Alignment.CenterEnd

    val weatherImageAlignment by animateAlignmentAsState(weatherImageTargetAlignment)
    val currentWeatherDetailsAlignment by animateAlignmentAsState(
        currentWeatherDetailsTargetAlignment
    )

    Box(
        modifier = Modifier
            .height(animatedHeight)
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Box(
            modifier = Modifier.align(weatherImageAlignment), contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .width(imageWidth)
                    .height(imageHeight)
                    .align(Alignment.BottomCenter)
                    .offset(y = (30).dp)
                    .blur(90.dp, BlurredEdgeTreatment.Unbounded)
                    .clip(CircleShape)
                    .background(currentWeather.weatherColor.blur.copy(alpha = 0.45f))
            )
            Image(
                painter = painterResource(currentWeather.weatherImage),
                contentDescription = "icon mainly clear",
                modifier = Modifier
                    .width(imageWidth)
                    .height(imageHeight)
                    .zIndex(1f)
            )
        }

        Column(
            modifier = Modifier.align(currentWeatherDetailsAlignment),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "${currentWeather.weatherData?.temperature?.toInt()}°C",
                color = currentWeather.weatherColor.textColor,
                fontFamily = urbanist,
                fontWeight = FontWeight.SemiBold,
                fontSize = 64.sp,
                letterSpacing = 0.25.sp,
            )
            Text(
                text = "${currentWeather.weatherData?.weatherDescription}",
                color = currentWeather.weatherColor.textSubTitleColor,
                fontFamily = urbanist,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
            )
            Spacer(Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .size(height = 35.dp, width = 168.dp)
                    .clip(shape = CircleShape)
                    .background(currentWeather.weatherColor.cardAboveColor),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
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
                            text = "${currentWeather.weatherData!!.temperatureMax.toInt()}°C",
                            color = currentWeather.weatherColor.cardContentAboveColor,
                            fontFamily = urbanist,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            letterSpacing = 0.25.sp,
                        )
                    }
                    Box(
                        modifier = Modifier
                            .height(14.dp)
                            .width(1.dp)
                            .border(
                                width = 1.dp, color = currentWeather.weatherColor.cardAboveLineColor
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
                            text = "${currentWeather.weatherData!!.temperatureMin.toInt()}°C",
                            color = currentWeather.weatherColor.cardContentAboveColor,
                            fontFamily = urbanist,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            letterSpacing = 0.25.sp,
                        )
                    }
                }
            }
        }
    }
}
