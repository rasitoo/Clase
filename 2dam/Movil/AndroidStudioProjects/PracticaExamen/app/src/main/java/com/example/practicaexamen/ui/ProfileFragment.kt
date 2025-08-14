package com.example.practicaexamen.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.practicaexamen.R
import com.example.practicaexamen.databinding.FragmentProfileBinding
import com.example.practicaexamen.ui.viewModels.ProfileViewModel
import com.example.practicaexamen.utils.CameraUtils


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var cameraUtils: CameraUtils
    private lateinit var context: Context
    private lateinit var takePictureLauncher: ActivityResultLauncher<Uri>
    private lateinit var selectedPhoto: ActivityResultLauncher<PickVisualMediaRequest>
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<Array<String>> // Declaración de permisos
    val permissionsArrayStorage = arrayOf(
        Manifest.permission.READ_MEDIA_IMAGES,
        Manifest.permission.READ_MEDIA_VIDEO,
        Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    val permissionsArrayCamera= arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.READ_MEDIA_IMAGES,
        Manifest.permission.READ_MEDIA_VIDEO,
        Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    private val viewModel: ProfileViewModel by viewModels()
    private var selectPath: String = ""
    private var imageUri: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context = requireContext()
        initPermissionLauncher()
        cameraUtils = CameraUtils(requireContext(), requireContext().contentResolver)
        //Para galeria
        inicializarSelectedPhoto()
        //ParaFotos
        permisosCamara()
        // Solicitar todos los permisos cuando el fragmento se muestra
        binding.buttonGallery.setOnClickListener {
            abrirGaleria() // Abre la galería si se tiene el permiso
        }

        binding.buttonCamera.setOnClickListener {
            tomarFoto()
        }
    }
    fun initPermissionLauncher() {
        requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            permissions.forEach { (permission, isGranted) ->
                if (isGranted) {
                    println("$permission granted")
                } else {
                    println("$permission denied")
                }
            }
        }
    }
    //Para galeria
    private fun permisosParaGaleria() {
        requestPermissionLauncher.launch(permissionsArrayStorage)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.READ_MEDIA_IMAGES
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissionLauncher.launch(arrayOf(android.Manifest.permission.READ_MEDIA_IMAGES))
            }
        }
    }
    fun inicializarSelectedPhoto() {
        selectedPhoto = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                // Imagen seleccionada
                selectPath = uri.toString()
                mostrarImagen(selectPath, binding.imageView)
            } else {
                // Imagen no seleccionada
                Toast.makeText(requireContext(), "No hay imagen seleccionada", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun abrirGaleria() {
        permisosParaGaleria()
        selectedPhoto.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) // Abre la galería
    }
    // Método para manejar los permisos de la cámara
    private fun tomarFoto() {
        val list =  cameraUtils.hasCameraPermission(context)
        for (String in list) {
            Toast.makeText(requireContext(), String, Toast.LENGTH_LONG).show()

        }
        if (cameraUtils.hasCameraPermission(context).isEmpty()) {
            cameraUtils.takePicture(takePictureLauncher)
            val uri = cameraUtils.getPhotoUri()

            mostrarImagen(uri.toString(), binding.imageView) // Mostrar la foto tomada }/
        }

    }
    fun permisosCamara() {
        requestPermissionLauncher.launch(permissionsArrayCamera)

        takePictureLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success) {
                viewModel.photoUri.value?.let { uri ->
                    viewModel.updatePhotoUri(uri)

                }
            }
        }
    }
    // Muestra la imagen seleccionada o tomada
    fun mostrarImagen(uri: String, imageView: ImageView) {
        imageUri = uri
        val uri2 = Uri.parse(uri)
        Glide.with(requireContext())
            .load(uri2)
            .into(imageView)
    }
}