package com.example.recuperacionrodrigotapiador.ui

import android.content.Context
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recuperacionrodrigotapiador.App
import com.example.recuperacionrodrigotapiador.R
import com.example.recuperacionrodrigotapiador.databinding.FragmentFilterBinding
import com.example.recuperacionrodrigotapiador.ui.recyclerviews.TareaAdapter
import com.example.recuperacionrodrigotapiador.ui.viewmodels.AddViewModel
import com.example.recuperacionrodrigotapiador.ui.viewmodels.AddViewModelFactory
import com.example.recuperacionrodrigotapiador.ui.viewmodels.FilterViewModel
import java.text.SimpleDateFormat
import java.util.Locale

class FilterFragment : Fragment() {
    lateinit var binding: FragmentFilterBinding
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
        binding = FragmentFilterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context = requireContext()

        viewModel.fetchTareas()
        setupRecyclerView()

        binding.buttonCompras.setOnClickListener {
            filtrarCompras()
        }
        binding.buttonProceso.setOnClickListener {
            filtrarProceso()
        }
        binding.buttonTrabajo.setOnClickListener {
            filtrarTrabajo()
        }
        binding.buttonUrgente.setOnClickListener {
            filtrarUrgente()
        }
        binding.buttonPersonal.setOnClickListener {
            filtrarPersonal()
        }
        binding.buttonFinalizado.setOnClickListener {
            filtrarFinalizado()
        }

    }

    private fun filtrarTrabajo() {
            val listafiltrada = viewModel.filterWork()
            mAdapter.setDato(listafiltrada)
            mAdapter.notifyDataSetChanged()
    }

    private fun filtrarUrgente() {
        val listafiltrada = viewModel.filterUrgent()
        mAdapter.setDato(listafiltrada)
        mAdapter.notifyDataSetChanged()    }

    private fun filtrarPersonal() {
        val listafiltrada = viewModel.filterPersonal()
        mAdapter.setDato(listafiltrada)
        mAdapter.notifyDataSetChanged()    }

    private fun filtrarFinalizado() {
        val listafiltrada = viewModel.filterEnd()
        mAdapter.setDato(listafiltrada)
        mAdapter.notifyDataSetChanged()    }

    private fun filtrarProceso() {
        val listafiltrada = viewModel.filterProcess()
        mAdapter.setDato(listafiltrada)
        mAdapter.notifyDataSetChanged()    }

    private fun filtrarCompras() {
        val listafiltrada = viewModel.filterShopping()
        mAdapter.setDato(listafiltrada)
        mAdapter.notifyDataSetChanged()    }

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


}