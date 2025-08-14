package com.example.practicaexamen.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaexamen.App
import com.example.practicaexamen.R
import com.example.practicaexamen.databinding.FragmentReservationsBinding
import com.example.practicaexamen.models.Restaurant
import com.example.practicaexamen.ui.recycleViews.reservationsAdapter.ReservationsAdapter
import com.example.practicaexamen.ui.recycleViews.DatoOnclickListener
import com.example.practicaexamen.ui.recycleViews.reservationsAdapter.SwipeToDelete
import com.example.practicaexamen.ui.viewModels.ReservationsViewModel
import com.example.practicaexamen.ui.viewModels.ReservationsViewModelFactory


class ReservationsFragment : Fragment(), DatoOnclickListener {

    private lateinit var binding: FragmentReservationsBinding
    private lateinit var mAdapter: ReservationsAdapter
    private lateinit var mLinearLayout: LinearLayoutManager
    private var rest: Int = -1


    private val viewmodel: ReservationsViewModel by activityViewModels {
        ReservationsViewModelFactory(App.database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReservationsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // viewmodel.deleteall()
        //  viewmodel.generarProductos()
        viewmodel.fetchReservations()
        setupRecyclerview()
//        boton_nuevo_elemento()
        boton_lista_filtrada()
        desfiltrar()
        filtradodinamico()

    }

    private fun setupRecyclerview() {
        mAdapter = ReservationsAdapter(mutableListOf(), this)
        mLinearLayout = LinearLayoutManager(requireContext())

        //cargar los datos

        binding.Recyfiltered.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayout
            adapter = mAdapter
        }
        viewmodel.reservations.observe(viewLifecycleOwner) { reservations ->
            mAdapter.setDato(
                reservations
            )
        }
        val itemTouchHelper = ItemTouchHelper(
            SwipeToDelete(
                mAdapter, this
            )
        )
        itemTouchHelper.attachToRecyclerView(binding.Recyfiltered)
    }


    fun deleteProd(position: Int) {
        val item = mAdapter.reservationsList[position] //contactList es la variable del adaptador
        mAdapter.delete(position)
        viewmodel.deleteReservation(item)

    }

    fun filtradodinamico() {
        binding.Filtertext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                // Actualiza la vista cuando el texto cambia
                s?.let {
                    val texto = s.toString().trim()
                    if (texto.isNotEmpty() && texto.isDigitsOnly()) {
                        rest = texto.toInt()
                        val listafiltrada = viewmodel.filter(rest)
                        mAdapter.setDato(listafiltrada)
                        mAdapter.notifyDataSetChanged()
                    } else {
                        // Restaura la vista original si el campo de texto está vacío
                        mAdapter.setDato(viewmodel.reservations.value!!)
                        mAdapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }

    //    private fun boton_nuevo_elemento() {
//        binding.Add.setOnClickListener {
//            val action = ProductsDirections.actionProductsToDetailProduct(-1)
//            requireView().findNavController().navigate(action) }
//    }
    private fun boton_lista_filtrada() {
        binding.Filtrar.setOnClickListener {
            val cat = binding.Filtertext.text.toString().trim().toInt()
            val listafiltrada = viewmodel.filter(cat)

            if (listafiltrada.isNotEmpty()) {
                Toast.makeText(requireContext(), "Filtro aplicado con éxito", Toast.LENGTH_SHORT)
                    .show()
                mAdapter.setDato(listafiltrada)
            } else {
                Toast.makeText(requireContext(), "No se encontraron resultados", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun desfiltrar() {
        binding.reiniciarbuton.setOnClickListener {
            val lista = viewmodel.reservations.value
            if (lista != null && lista.isNotEmpty())
                mAdapter.setDato(viewmodel.reservations.value!!)
        }
    }

    override fun onClickEdit(id: Int?) {
        findNavController().navigate(R.id.reservaFragment)
    }

}