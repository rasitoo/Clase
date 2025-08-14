package com.example.repasoanteriorcurso.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repasoanteriorcurso.App
import com.example.repasoanteriorcurso.databinding.FragmentListadoBinding
import com.example.repasoanteriorcurso.models.Ciudad
import com.example.repasoanteriorcurso.models.Registro
import com.example.repasoanteriorcurso.recycler.CiudadAdapter
import com.example.repasoanteriorcurso.recycler.CiudadOnClickListener
import com.example.repasoanteriorcurso.ui.viewmodels.ListadoViewModel
import com.example.repasoanteriorcurso.ui.viewmodels.ListadoViewModelFactory


class ListadoFragment : Fragment(), CiudadOnClickListener {
    private lateinit var binding: FragmentListadoBinding
    private lateinit var mAdapter: CiudadAdapter
    private lateinit var mLinearLayout: LinearLayoutManager
    private var rest: Int = -1
    private val viewmodel: ListadoViewModel by activityViewModels {
        ListadoViewModelFactory(App.database)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListadoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.fetchRegisters()
        setupRecyclerView()
        setButtons()
    }

    private fun setupRecyclerView() {
        mAdapter = CiudadAdapter(mutableListOf(), this)
        mLinearLayout = LinearLayoutManager(requireContext())

        //cargar los datos

        binding.recyclerViewFilter.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayout
            adapter = mAdapter
        }
        viewmodel.registers.observe(viewLifecycleOwner) { registers ->
            mAdapter.setDato(
                registers
            )
        }
//        val itemTouchHelper = ItemTouchHelper(
//            SwipeToDelete(
//                mAdapter, this
//            )
//        )
//        itemTouchHelper.attachToRecyclerView(binding.recyclerViewFilter)
    }

    private fun setButtons() {
        binding.btnNoFiltro.setOnClickListener {
            binding.etFiltro.apply {
                visibility = View.GONE
                text?.clear()
            }
        }

        binding.btnFiltro.setOnClickListener {
            binding.etFiltro.visibility = View.VISIBLE
        }
    }
    override fun onClick(ciudad: Registro) {
        TODO("Not yet implemented")
    }
}