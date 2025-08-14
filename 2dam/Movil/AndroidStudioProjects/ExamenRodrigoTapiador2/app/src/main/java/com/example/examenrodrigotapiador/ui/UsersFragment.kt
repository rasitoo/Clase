package com.example.examenrodrigotapiador.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examenrodrigotapiador.R
import com.example.examenrodrigotapiador.ui.viewModels.UsersViewModel

class UsersFragment : Fragment() {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val viewModel: UsersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }
}