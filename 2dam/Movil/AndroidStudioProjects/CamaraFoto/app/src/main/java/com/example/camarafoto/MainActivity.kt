package com.example.camarafoto

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import com.example.camarafoto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var camaraUtils: CamaraUtils
    private lateinit var context: Context
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<Array<String>>
    private lateinit var takePictureLauncher: ActivityResultLauncher<Uri>
    private val viewModel: CamaraViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this
        camaraUtils = CamaraUtils(context,contentResolver)

        requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
            permissions ->
            val allPermissionsGranted = permissions.all { it.value }
            if (allPermissionsGranted){
                Toast.makeText(this, "Todos los permisos concedidos", Toast.LENGTH_SHORT).show()
                camaraUtils.takePicture(takePictureLauncher)
            }else{
                val rationalRequired = permissions.keys.any{ permission ->
                    ActivityCompat.shouldShowRequestPermissionRationale(this,permission)
                }
                if (rationalRequired){
                    Toast.makeText(this, "Se necesitan los permisos para continuar", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Habilita los permisos en los ajustes de Android", Toast.LENGTH_SHORT).show()

                }
            }
        }

        takePictureLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()){success->
            if (success){
                viewModel.updatePhotoUri(camaraUtils.getPhotoUri())
            }
        }
        viewModel.photoUri.observe(this, Observer { uri ->
            uri?.let{
                binding.shapeableImageView.setImageURI(it)
                Toast.makeText(this,"Foto guardada en: $uri", Toast.LENGTH_SHORT).show()
            }
        })

        binding.ButtonFoto.setOnClickListener {
            val permissionsNeeded = camaraUtils.hasCameraPermission(context)
            if (permissionsNeeded.isNotEmpty()) {
                requestPermissionLauncher.launch(permissionsNeeded.toTypedArray())
            }else{
                camaraUtils.takePicture(takePictureLauncher)
            }
        }
    }

}