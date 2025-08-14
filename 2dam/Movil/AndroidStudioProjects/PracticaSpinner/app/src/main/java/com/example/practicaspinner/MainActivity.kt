package com.example.practicaspinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val planetaList = arrayListOf<String>(
        "Mercurio", "Venus", "Tierra", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Spinner1, con arrayList
        // El sitio donde estás, como lo quieres mostrar y la lista declarada en el programa
        binding.spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, planetaList)

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //Cuando se selecciona un elemento
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, posicion: Int, p3:
                Long
            ) {
                //Almacena el dato seleccionado
                var seleccion = parent?.getItemAtPosition(posicion).toString()
                Toast.makeText(
                    this@MainActivity,
                    " Elemento seleccionado $seleccion",
                    Toast.LENGTH_LONG
                ).show()
                Toast.makeText(
                    this@MainActivity,
                    " Elemento seleccionado ${planetaList[posicion]}",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        //Spinner1, con xml srings
        //El sitio donde estás, el array elegido y como lo quieres mostrar
        binding.spinner2.adapter=ArrayAdapter.createFromResource(this, R.array.planetasEsp, android.R.layout.simple_spinner_item )
        //Responde a la seleccion del usuario
        binding.spinner2.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                //Cuando se selecciona un elemento
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, posicion: Int, p3:
                    Long
                ) {
                    //Almacena el dato seleccionado
                    var seleccion = parent?.getItemAtPosition(posicion).toString()
                    Toast.makeText(
                        this@MainActivity, " Elemento seleccionado $seleccion",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    }
}