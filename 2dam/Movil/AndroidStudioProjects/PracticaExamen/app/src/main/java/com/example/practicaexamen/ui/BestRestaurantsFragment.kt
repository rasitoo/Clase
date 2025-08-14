package com.example.practicaexamen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaexamen.App
import com.example.practicaexamen.R
import com.example.practicaexamen.databinding.FragmentBestRestaurantsBinding
import com.example.practicaexamen.models.Restaurant
import com.example.practicaexamen.ui.recycleViews.DatoOnclickListener
import com.example.practicaexamen.ui.recycleViews.restaurantAdapter.RestaurantAdapter
import com.example.practicaexamen.ui.viewModels.BestViewModel
import com.example.practicaexamen.ui.viewModels.BestViewModelFactory
import com.example.practicaexamen.ui.viewModels.ReservationViewModel
import com.example.practicaexamen.ui.viewModels.ReservationViewModelFactory
import kotlinx.coroutines.launch

class BestRestaurantsFragment : Fragment(), DatoOnclickListener {
    private lateinit var binding: FragmentBestRestaurantsBinding

    //Este fragment tiene recycler
    //declarar el objeto adapter
    private lateinit var mAdapter: RestaurantAdapter

    //declarar el layoutManager
    private lateinit var mLayoutManager: LinearLayoutManager

    //Viewmodel para pasar la categoría del restaurante elegido
    //SI NO PONEMOS ACTIVITYVIEWMODELS LOS FRAGMENT NO COMPARTIRAN VIEWMODEL
    private val bestViewModel: BestViewModel by activityViewModels {
        BestViewModelFactory(App.database)
    }
    private val reservationViewModel: ReservationViewModel by activityViewModels {
        ReservationViewModelFactory(App.database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBestRestaurantsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        bestViewModel.reloadDatabase()
        bestViewModel.generateCategoriesAndRestaurants()
        observeViewModel()
        setupRecyclerView()
        bestViewModel.fetchRestaurants()
    }

    private fun observeViewModel() {
        bestViewModel.restaurants.observe(viewLifecycleOwner, Observer { restaurants ->
            mAdapter.updateRestaurants(restaurants)
        })

    }

    private fun setupRecyclerView() {
        mAdapter = RestaurantAdapter(mutableListOf(), this)
        mLayoutManager = LinearLayoutManager(requireContext())

        binding.recycler.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
    }


    override fun onClickEdit(id: Int?) {
        viewLifecycleOwner.lifecycleScope.launch {
            if (id != null) {
                reservationViewModel.setSelectedRestaurant(id)
                findNavController().navigate(R.id.reservaFragment)
            }
        }

    }
    val listDay = listOf(
        "buffet",
        "especialidad",
        "gourmet",
        "llevar",
        "rapida",
        "tematica"
    )

}
