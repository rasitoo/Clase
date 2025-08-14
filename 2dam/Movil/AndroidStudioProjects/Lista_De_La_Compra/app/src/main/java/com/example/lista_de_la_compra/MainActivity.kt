package com.example.lista_de_la_compra

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lista_de_la_compra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProductoOnClickListener {
    lateinit var binding: ActivityMainBinding

    private lateinit var mAdapter: ProductoAdapter
    private lateinit var mLayoutManager: LinearLayoutManager

    private lateinit var listProducto: MutableList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //      setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listProducto = mutableListOf()
        setupRecyclerView()

        binding.imageButtonAdd.setOnClickListener { addProducto() }

    }

    private fun addProducto() {
        val elem = binding.editTextItem.text.toString()

        if (elem.isNotBlank()) {
            val producto = Producto(elem.trim())
            mAdapter.addProducto(producto)

            binding.editTextItem.text?.clear()
        }
    }

    private fun setupRecyclerView() {
        mAdapter = ProductoAdapter(listProducto, this)
        mLayoutManager = LinearLayoutManager(this)
        binding.recycler.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
    }

    override fun OnClickDelete(producto: Producto) {
        val builder = AlertDialog.Builder(this)
            .setTitle("Borrar producto")
            .setPositiveButton("OK") { dialogInterface, i ->
                mAdapter.deleteProducto(producto)
            }
            .setNegativeButton("Cancelar", null)
        builder.create().show()
    }
}