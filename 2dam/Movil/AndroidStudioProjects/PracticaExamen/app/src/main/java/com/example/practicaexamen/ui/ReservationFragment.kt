package com.example.practicaexamen.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.practicaexamen.App
import com.example.practicaexamen.databinding.FragmentReservationBinding
import com.example.practicaexamen.models.Reservation
import com.example.practicaexamen.ui.viewModels.ReservationViewModel
import com.example.practicaexamen.ui.viewModels.ReservationViewModelFactory
import kotlinx.coroutines.launch

class ReservationFragment : Fragment() {
    private lateinit var binding: FragmentReservationBinding
    private val viewModel: ReservationViewModel by activityViewModels {
        ReservationViewModelFactory(App.database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReservationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.selectedRestaurant.observe(viewLifecycleOwner) { restaurant ->
            restaurant?.let {
                binding.imageView4.setImageResource(restaurant.imageResId)
            }
        }
        binding.buttonFin.setOnClickListener {
            alertDialog()
        }
        binding.editTextDate.setOnClickListener {
            showDatePickerDialog()
        }
        binding.editTextTime.setOnClickListener {
            showTimePickerDialog()
        }
    }

    fun alertDialog() {
        val restaurant = viewModel.selectedRestaurant.value
        val restaurantName = restaurant?.name ?: "Desconocido"
        val restaurantCategory = restaurant?.category.toString() ?: "Desconocida"
        val numPersonas = binding.editTextNumber.text.toString().toIntOrNull() ?: 0
        val fecha = binding.editTextDate.text.toString()
        val hora = binding.editTextTime.text.toString()

        AlertDialog.Builder(requireContext())
            .setTitle("Reserva finalizada")
            .setMessage("Se ha creado una reserva para $numPersonas personas el $fecha a las $hora en el restaurante $restaurantName de categoría $restaurantCategory.")
            .setPositiveButton("ok") { dialogInterface, i ->
                val reserva = Reservation(numPersonas, fecha, hora, restaurant?.id ?: 0, null)
                lifecycleScope.launch {
                    viewModel.saveReservation(reserva)
                }
            }
            .setNegativeButton("no ok") { dialogInterface, i ->

            }
            .show()
    }

    private fun showDatePickerDialog() {
        val datePickerFragment = DatePickerFragment { year, month, day ->
            val selectedDate = "$day/${month + 1}/$year"
            binding.editTextDate.setText(selectedDate)
        }
        datePickerFragment.show(parentFragmentManager, "datePicker")
    }

    private fun showTimePickerDialog() {
        val timePickerFragment = TimePickerFragment { hour, minute ->
            val selectedTime = "$hour:${minute}"
            binding.editTextTime.setText(selectedTime)
        }
        timePickerFragment.show(parentFragmentManager, "timePicker")
    }
}