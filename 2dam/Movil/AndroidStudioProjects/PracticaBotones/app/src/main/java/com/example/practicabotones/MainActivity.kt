package com.example.practicabotones

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.practicabotones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNormal.setOnClickListener() {
            comprobarTexto()
        }
        binding.imageButton.setOnClickListener() {
            Toast.makeText(this, "${binding.imageButton} marcado", Toast.LENGTH_SHORT).show()
        }
        binding.buttonIcon.setOnClickListener() {
            Toast.makeText(this, "${binding.buttonIcon.text} marcado", Toast.LENGTH_SHORT).show()
        }
        binding.toggleButtonSiNo.setOnCheckedChangeListener { _, isChecked ->
            // Muestra un Toast con el estado
            if (isChecked) {
                Toast.makeText(this, "${binding.toggleButtonSiNo.text} marcado", Toast.LENGTH_SHORT)
                    .show()
            }
            if (!isChecked) {
                Toast.makeText(this, "${binding.toggleButtonSiNo.text} marcado", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            // Muestra un Toast con el estado
            if (isChecked) {
                Toast.makeText(this, "${binding.switch1.text} marcado", Toast.LENGTH_SHORT).show()
            }
            if (!isChecked) {
                Toast.makeText(this, "${binding.switch1.text} marcado", Toast.LENGTH_SHORT).show()
            }
        }


        binding.radioButton.tag = 10
        binding.radioButton2.tag = 20
        // Establecer un listener para el cambio de selección en el RadioGroup
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
        // Obtener el RadioButton seleccionado
            val selectedRadioButton =
                findViewById<RadioButton>(checkedId)
        // Verificar si se ha seleccionado alguna opción
            selectedRadioButton?.let {
        // Obtener el valor asociado al RadioButton
                val selectedValue = it.tag as? Int
                Toast.makeText(this, "Seleccionaste: $selectedValue", Toast.LENGTH_SHORT).show()
            }
        }

        binding.checBox.setOnCheckedChangeListener { _, isChecked ->
// Muestra un Toast con el estado
            if (isChecked) {
                Toast.makeText(this, "${binding.checBox.text} marcado", Toast.LENGTH_SHORT).show()
            }
            if(!isChecked){
                Toast.makeText(this, "${binding.checBox.text} desmarcado", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun comprobarTexto() {
        val texto = binding.editTextText.text.toString()
        if (texto.isNotEmpty()) {
            Toast.makeText(this, "Datos completos", Toast.LENGTH_LONG).show()
        }
        // El donde, el mensaje, la duración y que muestre
        else Toast.makeText(this, "Datos vacíos", Toast.LENGTH_LONG).show()
    }
}