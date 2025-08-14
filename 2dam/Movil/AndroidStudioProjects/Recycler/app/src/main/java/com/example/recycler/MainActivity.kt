package com.example.recycler

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DatoOnclickListener {
    lateinit var binding: ActivityMainBinding

    //declarar el objeto adapter
    private lateinit var mAdapter: UserAdapter

    //declarar el layoutManager
    private lateinit var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //funcion para construir el recycler
        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        mAdapter = UserAdapter(listDato, this)
        mLayoutManager = LinearLayoutManager(this)

        //vincular
        binding.recycler.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
    }
    override fun onClickEdit(datoUser: DatoUser) {
        Toast.makeText(this, datoUser.name, Toast.LENGTH_LONG).show()
    }
}
//se carga fuera de la class
val listDato = (1..10).map {
    DatoUser(
        name = "Titulo $it",
        imagen = "https://loremflickr.com/320/240?random=$it"
    )
}