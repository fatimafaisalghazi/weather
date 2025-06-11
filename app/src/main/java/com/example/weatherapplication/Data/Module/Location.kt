package com.example.weatherapplication.Data.Module

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.annotation.RequiresPermission
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority
import kotlinx.coroutines.tasks.await
import java.io.IOException

class LocationImpl(
    private val fusedLocation: FusedLocationProviderClient,
    private val geocoder: Geocoder
) {

    @SuppressLint("MissingPermission")
    @RequiresPermission(allOf = [
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ])
    suspend fun getCurrentLocation(): Result<Location> {
        return try {
            val location = fusedLocation.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY, null
            ).await() ?: return Result.failure(IllegalStateException("Location not found"))

            Result.success(location)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getAddressFromLocation(location: Location): String {
        return try {
            val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
            if (addresses?.isNotEmpty() == true) {
                addresses[0].getAddressLine(0)
            } else {
                "Unknown Location"
            }
        } catch (e: IOException) {
            "Error getting address"
        }
    }
}