package com.example.examenrodrigotapiador.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examenrodrigotapiador.R
import com.example.examenrodrigotapiador.databinding.FragmentInicioBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentInicioBinding.inflate(layoutInflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cardView2.setOnClickListener{irFragmentoMejores()}
        super.onViewCreated(view, savedInstanceState)
    }

    private fun irFragmentoMejores() {

        //ir al fragmento uno indicando el nombre de la id
        findNavController().navigate(R.id.mejoresFragment)    }

}