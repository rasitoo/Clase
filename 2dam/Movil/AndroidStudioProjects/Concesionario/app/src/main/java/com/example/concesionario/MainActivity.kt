package com.example.concesionario

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.concesionario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val marcaList =arrayListOf<String> ("Mercedes", "Ford", "Toyota", "Lexus", "Audi", "Mazda", "Nissan", "BMW", "Seat", "Volkswagen")
    private val modeloList = arrayListOf<String> ("Benz", "Mustang", "Corolla", "IS300", "A4", "MX3", "Skyline", "M3", "Leon", "Golf")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        workSpinner()
    }

    private fun workSpinner() {

        val marcaSpinner = binding.SpinnerMarca
        val modeloSpinner = binding.SpinnerModelo
        val colorSpinner = binding.SpinnerColor

        buildAdapterArrayList(marcaSpinner, marcaList)
        buildAdapterArrayList(modeloSpinner, modeloList)
        buildAdapterStrings(colorSpinner,R.array.colores)


    }

    private fun buildAdapterArrayList(marcaSpinner: Spinner, marcaList: ArrayList<String>) {
        marcaSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, marcaList)
    }
    private fun buildAdapterStrings(colorSpinner: Spinner, colores: Int) {
        colorSpinner.adapter = ArrayAdapter.createFromResource(this, R.array.colores, android.R.layout.simple_spinner_dropdown_item)
    }
}