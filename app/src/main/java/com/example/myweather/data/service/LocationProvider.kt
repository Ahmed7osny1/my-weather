package com.example.myweather.data.service

import com.example.myweather.data.dto.local.LocationData

interface LocationProvider {
    suspend fun getUserLocation(): LocationData?
}