package com.example.locationapp

import android.Manifest
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.locationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var locationUtils: LocationUtils
    private lateinit var context: Context

    private val viewModel: LocationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this
        locationUtils = LocationUtils(this)

        val requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
                if (permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
                    && permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
                ) {
                    locationUtils.requesLocationUpdates(viewModel)
                } else {
                    val rationaleRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                        context as Activity, Manifest.permission.ACCESS_COARSE_LOCATION
                    ) || ActivityCompat.shouldShowRequestPermissionRationale(
                        context as Activity,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )

                    if (rationaleRequired) {
                        Toast.makeText(context, "Se necesita permiso", Toast.LENGTH_LONG)
                    } else {
                        Toast.makeText(context, "Se necesitan los permisos", Toast.LENGTH_LONG)
                    }
                }
            }

        binding.button.setOnClickListener {

            if (locationUtils.hasLocationPermission(context)) {
                locationUtils.requesLocationUpdates(viewModel)
            } else {
                    requestPermissionLauncher.launch(arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ))
            }
        }

        viewModel.location.observe(this, Observer {
            if (it != null) {
                val address = locationUtils.reverseGeocodeLocation(context, it)
                binding.textView.setText("Direccion: ${it.latitude} ${it.longitude} \n $address")
            } else {
                binding.textView.setText("Ubicacion no disponible")
            }
        })

    }
}