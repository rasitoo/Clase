package edu.dam.dosapps

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.dam.dosapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    companion object {
        const val varCorreo = "correo"
        const val varContrasena = "contrasena"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Blogin.setOnClickListener {
            comprobarLogin()
        }
        binding.Register.setOnClickListener {
            iniciarRegistro()
        }
    }

    private fun iniciarRegistro() {
        val intent = Intent(this, registerSheet::class.java)
        startActivity(intent)
    }

    //comprobacion Login
    private fun comprobarLogin() {
        val email = binding.correo.text.toString()
        val contrasena = binding.contraseA.text.toString()
        if (!email.isEmpty() && !contrasena.isEmpty()) {
            if (email.equals(varCorreo) && contrasena.equals(varContrasena)) {
                Toast.makeText(this, "Datos correctos. Menudo crack", Toast.LENGTH_LONG).show()
            } else Toast.makeText(this, "Email o contraseña incorrectas", Toast.LENGTH_LONG).show()

        }
        // El donde, el mensaje, la duración y que muestre
        else Toast.makeText(this, "Email o contraseña vacíos", Toast.LENGTH_LONG).show()
    }

}

