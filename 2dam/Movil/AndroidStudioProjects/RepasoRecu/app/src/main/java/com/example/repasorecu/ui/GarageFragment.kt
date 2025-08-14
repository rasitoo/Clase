package com.example.repasorecu.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.examenrodrigotapiador.ui.DatePickerFragment
import com.example.repasorecu.App
import com.example.repasorecu.R
import com.example.repasorecu.databinding.FragmentGarageBinding
import com.example.repasorecu.models.Vehicle
import com.example.repasorecu.ui.recycleviews.vehicles.VehicleAdapter
import com.example.repasorecu.ui.viewmodels.GarageViewModel
import com.example.repasorecu.ui.viewmodels.GarageViewModelFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

class GarageFragment : Fragment() {
    lateinit var binding: FragmentGarageBinding
    private lateinit var context: Context


    private val viewModel: GarageViewModel by activityViewModels(){
        GarageViewModelFactory(App.database)
    }

    private lateinit var mAdapter: VehicleAdapter
    private lateinit var mLayoutManager: StaggeredGridLayoutManager
    private var rest: String = ""


    private var fechaRegistro: String = ""
    private var elementoCategoria: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGarageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context = requireContext()

        viewModel.fetchVehicles()
        setupRecyclerView()
        filtradodinamico()


//        binding.addbuton.setOnClickListener{
//            requireView().findNavController().navigate(R.id.detailAppointmentFragment)
//        }
        binding.addbuton.setOnClickListener {
            addAlertDialog()
        }
        binding.editTextDate.setOnClickListener {
            showDatePickerDialog()
        }
    }
    fun filtradodinamico() {
        binding.editTextDate.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    val texto = s.toString().trim()
                    if (texto.isNotEmpty() ) {
                        rest = texto
                        val listafiltrada = viewModel.filter(rest)
                        mAdapter.setDato(listafiltrada)
                        mAdapter.notifyDataSetChanged()
                    } else {
                        mAdapter.setDato(viewModel.vehicles.value!!)
                        mAdapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }
    private fun showDatePickerDialog() {
        val datePickerFragment = DatePickerFragment { year, month, day ->
            val selectedDate = "$day-${String.format("%02d", month + 1)}-$year"
            binding.editTextDate.setText(selectedDate)
            binding.textViewDay.setText(selectedDate)
        }
        datePickerFragment.show(parentFragmentManager, "datePicker")
    }

    private fun addAlertDialog() {
        val builder = MaterialAlertDialogBuilder(requireContext())
        val view = layoutInflater.inflate(R.layout.dialog_vehicle, null)
        builder.setView(view)

        fechaRegistro = otenerFechaRegistro()
        view.findViewById<TextView>(R.id.textViewFechaRegistro).setText(fechaRegistro)

        val spinnerCat = view.findViewById<Spinner>(R.id.spinnerCategoria)
        elementoCategoria = obtenerElemSpinner(spinnerCat)

        val dialog = builder.create()
        dialog.show()

        view.findViewById<Button>(R.id.buttonGuardar).setOnClickListener {
            val vehiculo = Vehicle(
                matricula = view.findViewById<EditText>(R.id.EditTextMatricula).text.toString(),
                entryDate = view.findViewById<TextView>(R.id.textViewFechaRegistro).text.toString(),
                type = elementoCategoria,
                id = null,
                priority = when (elementoCategoria) {
                    "Camion" -> 1
                    "Coche" -> 2
                    "Moto" -> 3
                    else -> 0
                },
                state = view.findViewById<RadioGroup>(R.id.radioGroup).checkedRadioButtonId.let { id ->
                    view.findViewById<RadioButton>(id).text.toString()
                })
            lifecycleScope.launch {
                viewModel.saveVehicle(vehiculo)
            }
            mAdapter.addVehicle(vehiculo)
            dialog.hide()
        }
        view.findViewById<Button>(R.id.buttonCancelar).setOnClickListener {
            dialog.hide()
        }
    }

    private fun obtenerElemSpinner(spinnerCat: Spinner?): String {
        spinnerCat?.adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.categoria_array,
            android.R.layout.simple_spinner_dropdown_item
        )

        spinnerCat?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                elementoCategoria = parent?.getItemAtPosition(position).toString()
                Toast.makeText(
                    requireContext(),
                    "elemento seleccionado ${elementoCategoria}",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        return elementoCategoria
    }

    private fun otenerFechaRegistro(): String {
        val fechaRegistro = SimpleDateFormat(
            "dd-MM-yyyy/HH:mm:ss a",
            Locale.getDefault()
        ).format(System.currentTimeMillis())
        return fechaRegistro
    }

    private fun setupRecyclerView() {
        mAdapter = VehicleAdapter(mutableListOf())
        mLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.RecyclerVehicles.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
        viewModel.vehicles.observe(viewLifecycleOwner) { vehicles ->
            mAdapter.setDato(
                vehicles
            )
        }
    }
}