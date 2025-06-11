package com.example.myweather.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.myweather.presentation.theme.BackgroundColorDay
import com.example.myweather.presentation.theme.BackgroundColorNight
import com.example.myweather.presentation.theme.BlurColor
import com.example.myweather.presentation.theme.CardAboveColorDay
import com.example.myweather.presentation.theme.CardAboveColorNight
import com.example.myweather.presentation.theme.CardAboveLineColorDay
import com.example.myweather.presentation.theme.CardBackgroundBorderColorDay
import com.example.myweather.presentation.theme.CardBackgroundBorderColorNight
import com.example.myweather.presentation.theme.CardBackgroundColorDay
import com.example.myweather.presentation.theme.CardBackgroundColorNight
import com.example.myweather.presentation.theme.CardContentAboveColorDay
import com.example.myweather.presentation.theme.CardContentAboveColorNight
import com.example.myweather.presentation.theme.CardContentAboveLineColorNight
import com.example.myweather.presentation.theme.CardContentColorDay
import com.example.myweather.presentation.theme.CardContentColorNight
import com.example.myweather.presentation.theme.CardSubContentColorDay
import com.example.myweather.presentation.theme.CardSubContentColorNight
import com.example.myweather.presentation.theme.IconLocationColorDay
import com.example.myweather.presentation.theme.IconLocationColorNight
import com.example.myweather.presentation.theme.NightBlurColor
import com.example.myweather.presentation.theme.NightSmallBlurColor
import com.example.myweather.presentation.theme.SmallBlurColor
import com.example.myweather.presentation.theme.TextSubTitleColorDay
import com.example.myweather.presentation.theme.TextSubTitleColorNight
import com.example.myweather.presentation.theme.TextTitleColorDay
import com.example.myweather.presentation.theme.TextTitleColorNight

data class WeatherAppColors(
    val backgroundColor: Brush,
    val iconLocationColor: Color,
    val blur: Color,
    val smallBlur: Color,
    val textColor: Color,
    val textSubTitleColor: Color,
    val cardAboveColor: Color,
    val cardContentAboveColor: Color,
    val cardAboveLineColor: Color,
    val cardContentColor: Color,
    val cardSubContentColor: Color,
    val cardBackgroundColor: Color,
    val cardBackgroundBorderColor: Color,
)

val WeatherAppDayColors = WeatherAppColors(
    backgroundColor = BackgroundColorDay,
    iconLocationColor = IconLocationColorDay,
    blur = BlurColor,
    smallBlur = SmallBlurColor,
    textColor = TextTitleColorDay,
    textSubTitleColor = TextSubTitleColorDay,
    cardAboveColor = CardAboveColorDay,
    cardContentAboveColor = CardContentAboveColorDay,
    cardAboveLineColor = CardAboveLineColorDay,
    cardContentColor = CardContentColorDay,
    cardSubContentColor = CardSubContentColorDay,
    cardBackgroundColor = CardBackgroundColorDay,
    cardBackgroundBorderColor = CardBackgroundBorderColorDay,
)

val WeatherAppDarkColors = WeatherAppColors(
    backgroundColor = BackgroundColorNight,
    iconLocationColor = IconLocationColorNight,
    blur = NightBlurColor,
    smallBlur = NightSmallBlurColor,
    textColor = TextTitleColorNight,
    textSubTitleColor = TextSubTitleColorNight,
    cardAboveColor = CardAboveColorNight,
    cardContentAboveColor = CardContentAboveColorNight,
    cardAboveLineColor = CardContentAboveLineColorNight,
    cardContentColor = CardContentColorNight,
    cardSubContentColor = CardSubContentColorNight,
    cardBackgroundColor = CardBackgroundColorNight,
    cardBackgroundBorderColor = CardBackgroundBorderColorNight,
)
