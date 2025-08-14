package com.example.calculadoranotas

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoranotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.psp.setOnCheckedChangeListener{ compoundButton: CompoundButton, isChecked ->
            if (isChecked){
                binding.notaPsp.visibility = View.VISIBLE
            }else{
                binding.notaPsp.visibility = View.INVISIBLE

            }
        }
        binding.movil.setOnCheckedChangeListener{ compoundButton: CompoundButton, isChecked ->
            if (isChecked){
                binding.notaMovil.visibility = View.VISIBLE
            }else{
                binding.notaMovil.visibility = View.INVISIBLE

            }
        }
        binding.datos.setOnCheckedChangeListener{ compoundButton: CompoundButton, isChecked ->
            if (isChecked){
                binding.notaDatos.visibility = View.VISIBLE
            }else{
                binding.notaDatos.visibility = View.INVISIBLE

            }
        }
        binding.interfaces.setOnCheckedChangeListener{ compoundButton: CompoundButton, isChecked ->
            if (isChecked){
                binding.notaInterfaces.visibility = View.VISIBLE
            }else{
                binding.notaInterfaces.visibility = View.INVISIBLE

            }
        }
        binding.empresa.setOnCheckedChangeListener{ compoundButton: CompoundButton, isChecked ->
            if (isChecked){
                binding.notaEmpresa.visibility = View.VISIBLE
            }else{
                binding.notaEmpresa.visibility = View.INVISIBLE

            }
        }

        binding.buttonCalcular.setOnClickListener {
            binding.textViewNotaMedia.setText("Nota media: " + calcularMedia())
        }

    }

    private fun calcularMedia() : Double {
        var notaTotal : Double = 0.0
        var numNotas : Double = 0.0


        if (binding.psp.isChecked){
            notaTotal += binding.notaPsp.text.toString().toDouble()
            numNotas ++
        }
        if (binding.movil.isChecked){
            notaTotal += binding.notaMovil.text.toString().toDouble()
            numNotas ++

        }
        if (binding.datos.isChecked){
            notaTotal += binding.notaDatos.text.toString().toDouble()
            numNotas ++

        }
        if (binding.interfaces.isChecked){
            notaTotal += binding.notaInterfaces.text.toString().toDouble()
            numNotas ++

        }
        if (binding.empresa.isChecked){
            notaTotal += binding.notaEmpresa.text.toString().toDouble()
            numNotas ++

        }

        return (notaTotal / numNotas)
    }
}