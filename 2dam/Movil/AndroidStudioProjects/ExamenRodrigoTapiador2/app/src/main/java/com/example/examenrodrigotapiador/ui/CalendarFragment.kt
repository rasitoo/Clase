package com.example.examenrodrigotapiador.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenrodrigotapiador.App
import com.example.examenrodrigotapiador.ui.viewModels.CalendarViewModel
import com.example.examenrodrigotapiador.R
import com.example.examenrodrigotapiador.databinding.FragmentCalendarBinding
import com.example.examenrodrigotapiador.ui.recycleViews.OnClickElement
import com.example.examenrodrigotapiador.ui.recycleViews.appointment.AppointmentsAdapter
import com.example.examenrodrigotapiador.ui.viewModels.CalendarViewModelFactory

class CalendarFragment : Fragment(), OnClickElement {
    private lateinit var binding: FragmentCalendarBinding
    private lateinit var mAdapter: AppointmentsAdapter
    private lateinit var mLinearLayout: LinearLayoutManager
    private var rest: String = ""


    private val viewModel: CalendarViewModel by activityViewModels() {
        CalendarViewModelFactory(App.database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalendarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchAppointments()
        setupRecyclerview()
        filtradodinamico()


        binding.addbuton.setOnClickListener{
            requireView().findNavController().navigate(R.id.detailAppointmentFragment)
        }
        binding.editTextDate.setOnClickListener {
            showDatePickerDialog()
        }
    }
    private fun setupRecyclerview() {
        mAdapter = AppointmentsAdapter(mutableListOf(), this)
        mLinearLayout = LinearLayoutManager(requireContext())

        //cargar los datos

        binding.RecyclerAppointments.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayout
            adapter = mAdapter
        }
        viewModel.appointments.observe(viewLifecycleOwner) { reservations ->
            mAdapter.setDato(
                reservations
            )
        }
    }

    fun filtradodinamico() {
        binding.editTextDate.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                // Actualiza la vista cuando el texto cambia
                s?.let {
                    val texto = s.toString().trim()
                    if (texto.isNotEmpty() ) {
                        rest = texto
                        val listafiltrada = viewModel.filter(rest)
                        mAdapter.setDato(listafiltrada)
                        mAdapter.notifyDataSetChanged()
                    } else {
                        // Restaura la vista original si el campo de texto está vacío
                        mAdapter.setDato(viewModel.appointments.value!!)
                        mAdapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }
    private fun showDatePickerDialog() {
        val datePickerFragment = DatePickerFragment { year, month, day ->
            val selectedDate = "$day/${month + 1}/$year"
            binding.editTextDate.setText(selectedDate)
            binding.textViewDay.setText(selectedDate)
        }
        datePickerFragment.show(parentFragmentManager, "datePicker")
    }
    override fun onclickElem(id: Int) {
        TODO("Not yet implemented")
    }
}