package edu.dam.dosapps

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.dam.dosapps.MainActivity.Companion.varContrasena
import edu.dam.dosapps.MainActivity.Companion.varCorreo
import edu.dam.dosapps.databinding.ActivityMainBinding
import edu.dam.dosapps.databinding.ActivityRegisterSheetBinding

class registerSheet : AppCompatActivity() {
    lateinit var binding: ActivityRegisterSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_main)
        binding = ActivityRegisterSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Bregister.setOnClickListener {
            comprobarDatos()
        }

    }

    private fun comprobarDatos() {
        val user = binding.userInput.text.toString()
        val email = binding.correoInput.text.toString()
        val contrasena = binding.contrasenaInput.text.toString()
        val contrasenacomp = binding.contrasenInputCheker.text.toString()
        var acept = false

        binding.switchCondiciones.setOnCheckedChangeListener { _, chekedId ->
            var choosen: String = "No has aceptado los terminos"
            when (chekedId) {
                true -> acept = true
                false -> acept = false
            }
        }
        if (!user.isEmpty() && !email.isEmpty() && !contrasena.isEmpty()) {
            if (contrasena.equals(contrasenacomp)) {
                if (acept)
                    Toast.makeText(this, "Datos correctos. Menudo crack", Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(
                        this,
                        "Debes aceptar los términos para continuar",
                        Toast.LENGTH_LONG
                    ).show()
            } else Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG)
                .show()

        }
        // El donde, el mensaje, la duración y que muestre
        else Toast.makeText(this, "Email o contraseña vacíos", Toast.LENGTH_LONG).show()
    }


}