package com.example.practicaexamen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.practicaexamen.R
import com.example.practicaexamen.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cardView2.setOnClickListener { goBestFragment() }
        binding.cardView.setOnClickListener { goCategoryFragment() }
        binding.cardView3.setOnClickListener { goLocationFragment() }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun goBestFragment() {
        findNavController().navigate(R.id.mejoresFragment)
    }
    private fun goLocationFragment() {
        findNavController().navigate(R.id.locationFragment)
    }
    private fun goCategoryFragment() {
        findNavController().navigate(R.id.categoryFragment)
    }
}