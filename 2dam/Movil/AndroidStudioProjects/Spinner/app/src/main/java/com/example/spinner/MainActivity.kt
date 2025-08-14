package com.example.spinner

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spinner.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val planetaList = arrayListOf<String>(
        "Mercurio", "Venus", "Tierra", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Variable spinner
        val simpleSpinner = binding.spinner

        //adaptdor desde strings.xml
        simpleSpinner.adapter = ArrayAdapter.createFromResource(
            this,  //contexto
            R.array.planeta_array, //con que se inicializa
            android.R.layout.simple_spinner_item //Como se inicializa
        )
        //adaptdor desde codigo
        simpleSpinner.adapter = ArrayAdapter(
            this,  //contexto
            android.R.layout.simple_spinner_item, //Como se inicializa
            planetaList //con que se inicializa

        )

        simpleSpinner.onItemSelectedListener = object : OnItemSelectedListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val seleccion = p0?.getItemAtPosition(position)
                Toast.makeText(
                    this@MainActivity,
                    "El planeta elegido es: $seleccion",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                TODO("Not yet implemented")
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}