package com.example.examenrodrigotapiador.ui

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.examenrodrigotapiador.ui.ItemViewModel
import com.example.examenrodrigotapiador.databinding.FragmentReservaBinding


class ReservaFragment : Fragment() {
    private lateinit var binding: FragmentReservaBinding
    private val viewModel: com.example.examenrodrigotapiador.ui.ItemViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReservaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.mutableDato.observe(viewLifecycleOwner) { item ->
            val resid = resources.getIdentifier(
                "restaurante_${item}",
                "drawable",
                context?.packageName
            )
            binding.imageView4.setImageResource(resid)
        }
        binding.buttonFin.setOnClickListener{
            alertDialog(binding.editTextNumber.text, binding.editTextDate.text)
        }
    }
    fun alertDialog(numper: Editable, date: Editable) {

        AlertDialog.Builder(requireContext())
            .setTitle("Reserva finalizada")
            .setMessage("Se ha creado una reserva para ${numper} personas el ${date}")
            .setPositiveButton("ok") { dialogInterface, i ->

            }
            .setNegativeButton("no ok") { dialogInterface, i ->

            }
            .show();
    }

}