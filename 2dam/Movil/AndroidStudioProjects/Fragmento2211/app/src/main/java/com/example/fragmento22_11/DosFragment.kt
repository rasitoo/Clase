package com.example.fragmento22_11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Observer
import com.example.fragmento22_11.databinding.FragmentDosBinding


class DosFragment : Fragment() {
    private lateinit var binding: FragmentDosBinding
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDosBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setFragmentResultListener("claveKey") { requestKey: String, bundle: Bundle ->
            val dato = bundle.getString("datoKey")
            binding.textView.setText(dato)
        }

        viewModel.mutableDato.observe(viewLifecycleOwner, Observer { item ->
            binding.textView.text = item
        })
    }
}