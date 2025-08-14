package com.example.examenrodrigotapiador.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.examenrodrigotapiador.ui.viewModels.HomeViewModel
import com.example.examenrodrigotapiador.R
import com.example.examenrodrigotapiador.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

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
        binding.cardView2.setOnClickListener { goCalendarFragment() }
        binding.cardView3.setOnClickListener { goUsersFragment() }
        super.onViewCreated(view, savedInstanceState)
    }
    private fun goCalendarFragment() {
        findNavController().navigate(R.id.calendarFragment)
    }
    private fun goUsersFragment() {
        findNavController().navigate(R.id.usersFragment)
    }
}