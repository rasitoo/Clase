package com.example.practicaexamen.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.practicaexamen.databinding.FragmentLocationBinding
import com.example.practicaexamen.ui.viewModels.LocationViewModel
import com.example.practicaexamen.utils.LocationUtils


class LocationFragment : Fragment() {
    private lateinit var binding: FragmentLocationBinding

    private lateinit var context: Context
    private lateinit var locationUtils: LocationUtils

    private val viewModel: LocationViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context = this.requireContext()
        locationUtils = LocationUtils(context)


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


        viewModel.location.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                val address = locationUtils.reverseGeocodeLocation(context, it)
                binding.textView.setText("Direccion: ${it.latitude} ${it.longitude} \n $address")
            } else {
                binding.textView.setText("Ubicacion no disponible")
            }
        })

    }

}