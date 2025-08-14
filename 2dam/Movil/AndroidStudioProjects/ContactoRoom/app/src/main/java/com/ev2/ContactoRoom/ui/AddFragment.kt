package com.ev2.ContactoRoom.ui

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
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
import com.ev2.ContactoRoom.App
import com.ev2.ContactoRoom.databinding.FragmentAddBinding
import com.ev2.ContactoRoom.db.Contact
import kotlinx.coroutines.launch

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding

    private val args: AddFragmentArgs by navArgs()

    private var requestPermissionLauncher: ActivityResultLauncher<>
    private var selectPath : String = ""
    //private val viewModel: AddViewModel by viewModels { AddViewModelFactory(App.db.contactDao())  }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun checkAndRequestPermissions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if (ContextCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.READ_MEDIA_IMAGES
            ) != PackageManager.PERMISSION_GRANTED
                )
            {
                requestPermissionLauncher.launch(android.Manifest.permission.READ_MEDIA_IMAGES)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {isGranted: Boolean ->
                if (isGranted){
                    Toast.makeText(requireContext(),"Permiso concedido",Toast.LENGTH_LONG).show()

                }else{
                    Toast.makeText(requireContext(),"Permiso denegado",Toast.LENGTH_LONG).show()
                }
            }

        if (args.contactId != -1) {
            lifecycleScope.launch {
                val contact = App.db.contactDao().getById(args.contactId)

                binding.nombre.setText(contact.name)
                binding.numeroTelefono.setText(contact.phone)
            }
        } else {
            binding.buttonAdd.setOnClickListener { addContact() }
        }
        binding.imageButton.setOnClickListener{openGallery()}
    }

    private fun addContact() {
        val contact = Contact(
            id = if (args.contactId == -1) 0 else args.contactId,
            name = binding.nombre.text.toString(),
            phone = binding.numeroTelefono.text.toString(),
            image = selectPath
        )
        /*CoroutineScope(Dispatchers.IO).launch{
            App.db.contactDao().insertContact(contact)
        }*/

        lifecycleScope.launch {
            if (args.contactId == -1){
                App.db.contactDao().insert(contact)
            }else{
                App.db.contactDao().update(contact)
            }
        }
        Toast.makeText(requireContext(), "datos guardados", Toast.LENGTH_LONG).show()

        findNavController().navigateUp()
    }
    val selectedPhoto =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()){ uri ->
            if (uri != null) {
                val selectedImageUri = uri
                selectPath = selectedImageUri.toString()

                binding.imageButton.visibility = View.GONE
                binding.imageView2.setImageURI(selectedImageUri)
            }else{
                Toast.makeText(requireContext(),"No hay imagen seleccionada", Toast.LENGTH_LONG).show()
            }
        }
    private fun openGallery(){
        selectedPhoto.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }
}