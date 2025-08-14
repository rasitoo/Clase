package com.example.recuperacionrodrigotapiador.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recuperacionrodrigotapiador.App
import com.example.recuperacionrodrigotapiador.databinding.FragmentHomeBinding
import com.example.recuperacionrodrigotapiador.ui.recyclerviews.TareaAdapter
import com.example.recuperacionrodrigotapiador.ui.viewmodels.AddViewModel
import com.example.recuperacionrodrigotapiador.ui.viewmodels.AddViewModelFactory
import java.text.SimpleDateFormat
import java.util.Locale

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private lateinit var context: Context
    private val viewModel: AddViewModel by activityViewModels() {
        AddViewModelFactory(App.database)
    }
    private lateinit var mAdapter: TareaAdapter
    private lateinit var mLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context = requireContext()

        viewModel.fetchTareas()
        setupRecyclerView()

        binding.buttonFiltrar.setOnClickListener{
            filtrado()
        }
        var fecha = obtenerFechaHoy()

        binding.textViewFecha.setText(fecha)
        val terminadas = viewModel.filterEnd().size
        binding.textViewCompletadas.setText("Completadas: " + terminadas.toString())
        val proceso = viewModel.filterProcess().size
        binding.textViewPendientes.setText("Pendientes: " + proceso.toString())

    }

    private fun filtrado() {

        val fecha = obtenerFechaHoy()
        if (fecha.isNotEmpty()) {
            val listafiltrada = viewModel.filterDate(fecha)
            mAdapter.setDato(listafiltrada)
            mAdapter.notifyDataSetChanged()
        } else {
            mAdapter.setDato(viewModel.tareas.value!!)
            mAdapter.notifyDataSetChanged()
        }
    }


    private fun setupRecyclerView() {
        mAdapter = TareaAdapter(mutableListOf())
        mLayoutManager = LinearLayoutManager(requireContext())

        binding.RecyclerTareas.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
        viewModel.tareas.observe(viewLifecycleOwner) { vehicles ->
            mAdapter.setDato(
                vehicles
            )
        }
    }

    private fun obtenerFechaHoy(): String {
        val fecha = SimpleDateFormat(
            "dd-MM-yyyy",
            Locale.getDefault()
        ).format(System.currentTimeMillis())
        return fecha
    }
}