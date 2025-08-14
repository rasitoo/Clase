package com.example.fragmento22_11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import com.example.fragmento22_11.databinding.FragmentUnoBinding


class UnoFragment : Fragment() {
    private lateinit var binding: FragmentUnoBinding

    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUnoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonSet.setOnClickListener { enviarSet() }
        binding.buttonView.setOnClickListener { enviarViewModel() }
    }

    private fun enviarViewModel() {
        val dato = binding.editTextText.text.toString()
        viewModel.mostrarDato(dato)
    }

    private fun enviarSet() {
        val dato = binding.editTextText.text.toString()

        val bundle = Bundle()
        bundle.putString("datoKey", dato)

        setFragmentResult("claveKey", bundle)
    }

}