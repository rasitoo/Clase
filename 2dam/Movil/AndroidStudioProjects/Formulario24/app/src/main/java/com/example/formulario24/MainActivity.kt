package com.example.formulario24

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.formulario24.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val teacherList = arrayListOf<String>(
        "Profesor1", "Profesor2", "Profesor3"
    )
    private val studentList = arrayListOf<String>(
        "Curso1", "Curso2", "Curso3"
    )

    var selectedTeacher: String? = null
    var selectedEstud: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        radioGroupController()

        binding.button.setOnClickListener {

        }
    }

    private fun radioGroupController() {
        binding.radioGroup.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.radioButtonProf -> {
                    teacherView()
                }

                R.id.radioButtonEstud -> {
                    studentView()
                }
            }
        }
    }

    private fun studentView() {
        binding.LinearProf.visibility = View.GONE
        binding.LinearEstud.visibility = View.VISIBLE

//        binding.editTelEstud.text?.clear()

        val estudSimple = binding.spinner

        estudSimple.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, studentList)

        estudSimple.onItemSelectedListener = object : OnItemSelectedListener,
            AdapterView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedEstud = p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }

    private fun teacherView() {
        binding.LinearProf.visibility = View.VISIBLE
        binding.LinearEstud.visibility = View.GONE

//        binding.editTelEstud.text?.clear()

        val profSimple = binding.spinner2

        profSimple.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, teacherList)

        profSimple.onItemSelectedListener = object : OnItemSelectedListener,
            AdapterView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedTeacher = p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}