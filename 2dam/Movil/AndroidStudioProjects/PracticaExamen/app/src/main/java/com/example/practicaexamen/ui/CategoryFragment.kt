package com.example.practicaexamen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.practicaexamen.databinding.FragmentCategoryBinding
import com.example.practicaexamen.ui.recycleViews.categoryAdapter.CategoryAdapter
import com.example.practicaexamen.ui.viewModels.CategoryViewModel

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding

    private val viewModel: CategoryViewModel by viewModels()

    lateinit var mAdapter: CategoryAdapter
    private lateinit var mLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        bestViewModel.reloadDatabase()
//        bestViewModel.generateCategoriesAndRestaurants()
        observeViewModel()
        setupRecyclerView()
//        bestViewModel.fetchRestaurants()
    }

    private fun observeViewModel() {
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            binding.progress.visibility = if (state.loading) View.VISIBLE else View.GONE
            if (state.list != null) {
                mAdapter.listCategory = state.list
                mAdapter.notifyDataSetChanged()
            }
            if (state.error != null) {
                Toast.makeText(requireContext(), "error", Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun setupRecyclerView() {
        mAdapter = CategoryAdapter(mutableListOf(), {})
        mLayoutManager = GridLayoutManager(requireContext(), 2)

        binding.recyclerView.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
    }


//    override fun onClickEdit(datoRestaurante: Restaurant) {
//        reserveViewModel.setSelectedRestaurant(datoRestaurante)
//        findNavController().navigate(R.id.reservaFragment)
//
//    }


}