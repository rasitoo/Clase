package com.example.recuperacionrodrigotapiador.ui

import android.content.Context
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.recuperacionrodrigotapiador.App
import com.example.recuperacionrodrigotapiador.R
import com.example.recuperacionrodrigotapiador.databinding.FragmentAddBinding
import com.example.recuperacionrodrigotapiador.models.Tarea
import com.example.recuperacionrodrigotapiador.ui.viewmodels.AddViewModel
import com.example.recuperacionrodrigotapiador.ui.viewmodels.AddViewModelFactory
import kotlinx.coroutines.launch

class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding
    private lateinit var context: Context


    private val viewModel: AddViewModel by activityViewModels() {
        AddViewModelFactory(App.database)
    }

    private var fechaRegistro: String = ""
    private var elementoCategoria: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context = requireContext()
        binding.editTextDate.setOnClickListener {
            showDatePickerDialog()
        }
        binding.spinnerCategoria.adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.categoria_array,
            android.R.layout.simple_spinner_dropdown_item
        )
        val spinnerCat = binding.spinnerCategoria
        elementoCategoria = obtenerElemSpinner(spinnerCat)
        addButtons()
    }

    private fun obtenerElemSpinner(spinnerCat: Spinner): String {

        spinnerCat?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                elementoCategoria = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        return elementoCategoria
    }

    private fun addButtons() {

        binding.buttonGuardar.setOnClickListener {


            val tarea = Tarea(
                title = binding.EditTextTitulo.text.toString(),
                description = binding.EditTextDescripcion.text.toString(),
                state = binding.radioGroupEstado.checkedRadioButtonId.toString(),
                id = null,
                priority = binding.radioGroupPrioridad.checkedRadioButtonId.toString(),
                category = elementoCategoria,
                date = binding.editTextDate.text.toString()
            )
            lifecycleScope.launch {
                viewModel.saveTarea(tarea)
            }
        }


    }
    private fun showDatePickerDialog() {
        val datePickerFragment = DatePickerFragment { year, month, day ->
            val selectedDate = "$day-${String.format("%02d", month + 1)}-$year"
            binding.editTextDate.setText(selectedDate)
        }
        datePickerFragment.show(parentFragmentManager, "datePicker")
    }
}