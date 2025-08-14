package com.example.practicaexamen.utils

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import com.google.android.gms.location.LocationRequest
import android.os.Looper
import androidx.core.content.ContextCompat
import com.example.practicaexamen.models.Location
import com.example.practicaexamen.ui.viewModels.LocationViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng
import java.util.Locale

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
 */
class LocationUtils(context: Context) {
    private val _fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    fun requesLocationUpdates(viewModel: LocationViewModel){
        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult){
                super.onLocationResult(locationResult)

                locationResult.lastLocation?.let { result ->
                    val location = Location(latitude = result.latitude, longitude = result.longitude)
                    viewModel.updateLocation(location)
                }
            }
        }
        val locationRequest = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY, 1000
        ).build()

        _fusedLocationClient.requestLocationUpdates(locationRequest,locationCallback, Looper.getMainLooper())
    }
    fun hasLocationPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(
                    context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    fun reverseGeocodeLocation(context: Context, location: Location): String{
        val geocoder = Geocoder(context, Locale.getDefault())
        val coordinate = LatLng(location.latitude, location.longitude)
        val addresses: MutableList<Address>? =
            geocoder.getFromLocation(coordinate.latitude, coordinate.longitude, 1)
        return  if(addresses?.isNotEmpty() == true){
            addresses[0].getAddressLine(0)
        }else{
            "Direccion no encontrada"
        }
    }
}