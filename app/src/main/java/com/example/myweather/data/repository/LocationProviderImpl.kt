package com.example.myweather.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.annotation.RequiresPermission
import com.example.myweather.data.dto.local.LocationData
import com.example.myweather.data.service.LocationProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.IOException
import java.util.Locale
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class LocationProviderImpl(private val context: Context) : LocationProvider {

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    @RequiresPermission(allOf = ["android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"])
    override suspend fun getUserLocation(): LocationData {
        val location = getLastKnownLocation() ?: throw Exception("Failed to retrieve location")
        val cityName = getCityName(location.latitude, location.longitude)
            ?: throw Exception("Failed to retrieve city name")

        return LocationData(location.latitude, location.longitude, cityName)
    }

    @SuppressLint("MissingPermission")
    private suspend fun getLastKnownLocation(): Location? {
        return suspendCancellableCoroutine { continuation ->
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                if (location != null) {
                    continuation.resume(location)
                } else {
                    continuation.resumeWithException(Exception("Location is null"))
                }
            }.addOnFailureListener { exception ->
                continuation.resumeWithException(exception)
            }
        }
    }

    private fun getCityName(latitude: Double, longitude: Double): String? {
        val geocoder = Geocoder(context, Locale.getDefault())
        return try {
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            addresses?.firstOrNull()?.locality ?: throw Exception("City name is null")
        } catch (e: IOException) {
            throw Exception("Failed to retrieve city name: ${e.message}")
        } catch (e: IllegalArgumentException) {
            throw Exception("Invalid latitude/longitude values")
        }
    }
}
