package com.example.examenrodrigotapiador.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.examenrodrigotapiador.App
import com.example.examenrodrigotapiador.R
import com.example.examenrodrigotapiador.databinding.FragmentDetailAppointmentBinding
import com.example.examenrodrigotapiador.models.Appointment
import com.example.examenrodrigotapiador.ui.viewModels.CalendarViewModel
import com.example.examenrodrigotapiador.ui.viewModels.CalendarViewModelFactory
import kotlinx.coroutines.launch

class DetailAppointmentFragment : Fragment() {
    private lateinit var binding: FragmentDetailAppointmentBinding
    private lateinit var context: Context



    private val viewModel: CalendarViewModel by activityViewModels() {
        CalendarViewModelFactory(App.database)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailAppointmentBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
    fun cogerDatos(): Appointment {
        val producto = Appointment(
            id = null,
            asignatura = binding.asignaturaEditText.text.toString(),
            date = binding.editTextDate.text.toString(),
            aula = binding.aulaEditText.text.toString(),
            hora = binding.editTextTime.text.toString()
        )
        return producto
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context = requireContext()

        binding.saveButton.setOnClickListener{
            lifecycleScope.launch {
                viewModel.saveAppointment(cogerDatos())
                findNavController().navigateUp()
            }
        }
        binding.editTextDate.setOnClickListener{
            showDatePickerDialog()
        }
        binding.editTextTime.setOnClickListener{
            showTimePickerDialog()
        }
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