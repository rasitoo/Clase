package com.example.examenrodrigotapiador.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenrodrigotapiador.DatoOnclickListener
import com.example.examenrodrigotapiador.models.DatoRestaurante
import com.example.examenrodrigotapiador.ui.ItemViewModel
import com.example.examenrodrigotapiador.R
import com.example.examenrodrigotapiador.recycleViews.restaurantAdapter.RestauranteAdapter
import com.example.examenrodrigotapiador.databinding.FragmentMejoresBinding

class MejoresFragment : Fragment(), DatoOnclickListener {
    private lateinit var binding: FragmentMejoresBinding

    //Este fragment tiene recycler
    //declarar el objeto adapter
    private lateinit var mAdapter: RestauranteAdapter
    //declarar el layoutManager
    private lateinit var mLayoutManager: LinearLayoutManager

    //Viewmodel para pasar la categoría del restaurante elegido
    private val viewModel: ItemViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMejoresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
        binding.recycler.setOnClickListener { irFragmentoReserva() }
    }


    private fun irFragmentoReserva() {
        //ir al fragmento uno indicando el nombre de la id
        findNavController().navigate(R.id.reservaFragment)
    }

    private fun setupRecyclerview() {
        mAdapter = RestauranteAdapter(listDato, this)
        mLayoutManager = LinearLayoutManager(requireContext())

        //vincular
        binding.recycler.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
    }

    override fun onClickEdit(datoRestaurante: DatoRestaurante) {
        val dato = datoRestaurante.categoria
        viewModel.mostrarDato(dato)
        irFragmentoReserva()
    }


    val listCategory = listOf(
        "buffet",
        "especialidad",
        "gourmet",
        "llevar",
        "rapida",
        "tematica"
    )
    val listDato = (1..10).map {
        DatoRestaurante(
            name = "Restaurante $it",
            categoria = listCategory[it % listCategory.size]
        )
    }
}