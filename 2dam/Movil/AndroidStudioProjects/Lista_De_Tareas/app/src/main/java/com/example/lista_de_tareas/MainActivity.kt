package com.example.lista_de_tareas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.lista_de_tareas.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var mAdapter: PersonalAdapter
    private lateinit var mLayoutManager: StaggeredGridLayoutManager

    private var fechaRegistro: String = ""
    private var elementoCategoria: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        binding.floatingActionButton2.setOnClickListener { addAlertDialog() }
    }

    private fun addAlertDialog() {
        val builder = MaterialAlertDialogBuilder(this)
        val view = layoutInflater.inflate(R.layout.dialog_nota, null)
        builder.setView(view)

        fechaRegistro = otenerFechaRegistro()
        view.findViewById<TextView>(R.id.textViewFechaRegistro).setText(fechaRegistro)

        val spinnerCat = view.findViewById<Spinner>(R.id.spinnerCategoria)
        elementoCategoria = obtenerElemSpinner(spinnerCat)

        val dialog = builder.create()
        dialog.show()

        view.findViewById<Button>(R.id.buttonGuardar).setOnClickListener {
            val notaPersonal = NotaPersonal(
                descripcion = view.findViewById<EditText>(R.id.EditTextNotaPerson).text.toString(),
                fecha = view.findViewById<TextView>(R.id.textViewFechaRegistro).text.toString(),
                categoria = elementoCategoria
            )
            mAdapter.addNotaPerson(notaPersonal)
            dialog.hide()
        }
        view.findViewById<Button>(R.id.buttonCancelar).setOnClickListener {
            dialog.hide()
        }
    }

    private fun obtenerElemSpinner(spinnerCat: Spinner?): String {
        spinnerCat?.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.categoria_array,
            android.R.layout.simple_spinner_dropdown_item
        )

        spinnerCat?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                elementoCategoria = parent?.getItemAtPosition(position).toString()
                Toast.makeText(
                    this@MainActivity,
                    "elemento seleccionado ${elementoCategoria}",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        return elementoCategoria
    }

    private fun otenerFechaRegistro(): String {
        val fechaRegistro = SimpleDateFormat(
            "dd-MM-yyyy/HH:mm:ss a",
            Locale.getDefault()
        ).format(System.currentTimeMillis())
        return fechaRegistro
    }

    private fun setupRecyclerView() {
        mAdapter = PersonalAdapter(mutableListOf())
        mLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.recycler.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
    }
}