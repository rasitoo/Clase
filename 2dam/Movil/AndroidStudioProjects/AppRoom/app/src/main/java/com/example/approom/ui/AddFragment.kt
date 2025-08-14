package com.example.approom.ui

import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.approom.App
import com.example.approom.R
import com.example.approom.databinding.FragmentAddBinding
import com.example.approom.db.Contact
import kotlinx.coroutines.launch


class AddFragment : Fragment() {
    //resultado de los permisos
   private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

   private lateinit var  binding: FragmentAddBinding

   private val args: AddFragmentArgs by navArgs()

    private val viewModel : AddViewModel by viewModels {
        AddViewModelFactory(App.db.contactDao())
    }

    //variable para guardar el resultado de la seleccion de imagen
    private var selectPath: String = ""
    private var imageUri: String =""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //solicitar los permisos para
        requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    //permiso concedido
                    //Aqui puede continuar con la operacion
                    Toast.makeText(requireContext(), "Permiso concedido", Toast.LENGTH_LONG).show()

                } else {
                    //permiso denegado
                    Toast.makeText(requireContext(), "Permiso denegado", Toast.LENGTH_LONG).show()
                }
            }
        //verificar y solicitar permisos
        checkAndRequestPermissions()


        //recoger el dato que envia la navegacion
        val identif =  args.contactId //contactId es el nombre que esta en el args de la navegacion
        //preguntamos por su contenido
        if(identif != -1){
            //es una modificacion
            //realizamos consulta a la bd y mostrar los datos
            viewModel.allByIdContact(identif).observe(viewLifecycleOwner){ contact->
                //mostror los datos
                binding.editName.setText(contact.name)
                binding.editPhone.setText(contact.phone)
                binding.buttonAdd.setText("Modificar datos")

                imageUri = contact.image //cogemos la imagen
                val  uri = Uri.parse(imageUri)
                Log.i("fotoUri", "esta es la imagen $uri")
                Glide.with(requireContext())
                    .load(uri)
                    .into(binding.imageView)
            }

        }

        //ponemos el boton a la escucha para añadir
        binding.buttonAdd.setOnClickListener { onAddEditContact() }

        //poner el boton de cargar la imagen a la escucha
        binding.imageButton.setOnClickListener { openGallery() }

    }

    //resultado de la seleccion de imagen
    val selectedPhoto =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                //imagen seleccionada
                val seletedImageUri = uri
                selectPath = seletedImageUri.toString()

                //ocultar el selector y mostrar la imagen en el layout
                binding.imageButton.visibility = View.GONE
                binding.imageView.setImageURI(seletedImageUri)
            } else {
                //imagen no seleccionada
                Toast.makeText(requireContext(), "No hay imagen seleccionada", Toast.LENGTH_LONG)
                    .show()
            }
        }

    //lanzador para seleccionar una imagen del movil
    private fun openGallery() {
        selectedPhoto.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    //funcion para añadir y editar registo
    private fun onAddEditContact() {
        //1.- crear el objeto contact recogiendo los datos del layout

        val contacto = Contact(
            id = if(args.contactId == -1) 0 else args.contactId ,
            name= binding.editName.text.toString(), //dato recogidos del layout
            phone = binding.editPhone.text.toString(),
            //comprobamos si hay cambio en la imagen
            image = if(selectPath.isEmpty() ) imageUri else selectPath
        )

        //2.- almacenar los datos en la bd
        if (args.contactId == -1){
          viewModel.insert(contacto)
        }else{
           viewModel.update(contacto)
        }

        Toast.makeText(requireContext(), "datos guardados", Toast.LENGTH_LONG).show()
        findNavController().navigateUp()
    }

    private fun checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.READ_MEDIA_IMAGES
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissionLauncher.launch(android.Manifest.permission.READ_MEDIA_IMAGES)
            }
        }
    }

}