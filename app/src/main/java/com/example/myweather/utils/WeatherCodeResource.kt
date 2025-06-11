package com.example.myweather.utils

import com.example.myweather.R

object WeatherCodeResource {

    const val CODE_0 = 0
    const val CODE_1 = 1
    const val CODE_2 = 2
    const val CODE_3 = 3
    const val CODE_45 = 45
    const val CODE_48 = 48
    const val CODE_51 = 51
    const val CODE_53 = 53
    const val CODE_55 = 55
    const val CODE_56 = 56
    const val CODE_57 = 57
    const val CODE_61 = 61
    const val CODE_63 = 63
    const val CODE_65 = 65
    const val CODE_66 = 66
    const val CODE_67 = 67
    const val CODE_71 = 71
    const val CODE_73 = 73
    const val CODE_75 = 75
    const val CODE_77 = 77
    const val CODE_80 = 80
    const val CODE_81 = 81
    const val CODE_82 = 82
    const val CODE_85 = 85
    const val CODE_86 = 86
    const val CODE_95 = 95
    const val CODE_96 = 96
    const val CODE_99 = 99

    fun getWeatherDescription(weatherCode: Int): String {
        return when (weatherCode) {
            CODE_0 -> "Clear Sky"
            CODE_1 -> "Mainly Clear"
            CODE_2 -> "Partly Cloudy"
            CODE_3 -> "Overcast"
            CODE_45, CODE_48 -> "Foggy"
            CODE_51, CODE_53, CODE_55 -> "Drizzle"
            CODE_61, CODE_63, CODE_65 -> "Rainy"
            CODE_71, CODE_73, CODE_75 -> "Snowy"
            CODE_95 -> "Thunderstorm"
            else -> "Unknown Weather"
        }
    }


    fun getWeatherImage(weatherCode: Int, isDay: Boolean): Int {
        return when (weatherCode) {
            CODE_0 -> if (isDay) R.drawable.weather_0_day else R.drawable.weather_0_night
            CODE_1 -> if (isDay) R.drawable.weather_1_day else R.drawable.weather_1_night
            CODE_2 -> if (isDay) R.drawable.weather_2_day else R.drawable.weather_2_night
            CODE_3 -> R.drawable.weather_3_day_night
            CODE_45 -> if (isDay) R.drawable.weather_45_day else R.drawable.weather_45_night
            CODE_48 -> R.drawable.weather_48_day_night
            CODE_51 -> if (isDay) R.drawable.weather_51_day else R.drawable.weather_51_night
            CODE_53 -> if (isDay) R.drawable.weather_53_day else R.drawable.weather_53_night
            CODE_55 -> if (isDay) R.drawable.weather_55_day else R.drawable.weather_55_night
            CODE_56 -> R.drawable.weather_56_day_night
            CODE_57 -> R.drawable.weather_57_day_night
            CODE_61 -> if (isDay) R.drawable.weather_61_day else R.drawable.weather_61_night
            CODE_63 -> if (isDay) R.drawable.weather_63_day else R.drawable.weather_63_night
            CODE_65 -> if (isDay) R.drawable.weather_65_day else R.drawable.weather_65_night
            CODE_66 -> R.drawable.weather_66_day_night
            CODE_67 -> R.drawable.weather_67_day_night
            CODE_71 -> if (isDay) R.drawable.weather_71_day else R.drawable.weather_71_night
            CODE_73 -> if (isDay) R.drawable.weather_73_day else R.drawable.weather_73_night
            CODE_75 -> R.drawable.weather_75_day_night
            CODE_77 -> if (isDay) R.drawable.weather_77_day else R.drawable.weather_77_night
            CODE_80 -> if (isDay) R.drawable.weather_80_day else R.drawable.weather_80_night
            CODE_81 -> if (isDay) R.drawable.weather_81_day else R.drawable.weather_81_night
            CODE_82 -> if (isDay) R.drawable.weather_82_day else R.drawable.weather_82_night
            CODE_85 -> if (isDay) R.drawable.weather_85_day else R.drawable.weather_85_night
            CODE_86 -> if (isDay) R.drawable.weather_86_day else R.drawable.weather_86_night
            CODE_95 -> R.drawable.weather_95_day_night
            CODE_96 -> R.drawable.weather_96_night_day
            CODE_99 -> if (isDay) R.drawable.weather_99_day else R.drawable.weather_99_night
            else -> R.drawable.weather_0_day
        }
    }
}

