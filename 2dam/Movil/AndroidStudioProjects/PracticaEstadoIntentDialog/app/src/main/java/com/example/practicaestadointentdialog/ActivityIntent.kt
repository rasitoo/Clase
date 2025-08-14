package com.example.practicaestadointentdialog

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaestadointentdialog.databinding.ActivityIntentBinding

class ActivityIntent : AppCompatActivity(), DatePicker.OnDateSetListener,
    TimePickerFragment.OnTimeSelectedListener {
    private lateinit var binding: ActivityIntentBinding
    val booleanSeleccionUnica = BooleanArray(4);
    val booleanMultiple = BooleanArray(4);
    val booleanRadio = BooleanArray(4);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text = intent.getStringExtra("key_t")

        binding.button2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
//        alertDialog()
//        alertUnic()
//        alertMultipleRadio()
//        alertMultipleCasillas()
//        showAlertDialogPersonalizado()
        ShowDatePicker()
        showTimePicker()


    }

    fun alertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Alerta")
            .setMessage("Así se crea una alerta")
            .setPositiveButton("ok") { dialogInterface, i ->
                Toast.makeText(
                    this, "ok presionado ", Toast.LENGTH_LONG
                ).show()
            }
            .setNegativeButton("no ok") { dialogInterface, i ->
                Toast.makeText(
                    this, "no ok presionado ", Toast.LENGTH_LONG
                ).show()
            }
            .show();
    }

    fun alertUnic() {
        val constructor = AlertDialog.Builder(this)
        constructor.setTitle("Alerta")
        constructor.setItems(arrayOf("Series", "Peliculas", "Documentales", "Deportes"))
        { dialog, which ->
            booleanSeleccionUnica[which] = true
            Toast.makeText(this, "${booleanSeleccionUnica[which]}", Toast.LENGTH_LONG).show()
        }
        val dialog = constructor.create()
        dialog.show()
    }

    fun alertMultipleRadio() {
        booleanRadio.fill(false)
        val constructor = AlertDialog.Builder(this)
        constructor.setTitle("Lista de categorias-Botones")
            .setPositiveButton("ok") { dialogInterface, i ->
                Toast.makeText(this, "ok presionado", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("no ok") { dialogInterface, i ->
                booleanRadio.fill(false)
                Toast.makeText(this, "no ok presionado", Toast.LENGTH_LONG).show()
            }
        constructor.setSingleChoiceItems(
            arrayOf(
                "Series",
                "Peliculas",
                "Documentales",
                "Deportes"
            ), 0
        ) { dialog, which ->
            booleanRadio.fill(false)
            booleanRadio[which] = true;
        }
        val dialog = constructor.create()
        dialog.show()
    }

    fun alertMultipleCasillas() {
        booleanMultiple.fill(false)
        val constructor = AlertDialog.Builder(this)
        constructor.setTitle("Lista de categorias-Casillas")
            .setPositiveButton("ok") { dialogInterface, i ->
                Toast.makeText(this, "ok presionado", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("no ok") { dialogInterface, i ->
                Toast.makeText(this, "no ok presionado", Toast.LENGTH_LONG).show()
                booleanMultiple.fill(false)
            }
        constructor.setMultiChoiceItems(
            arrayOf(
                "Series",
                "Peliculas",
                "Documentales",
                "Deportes"
            ), null
        ) { _, which, _ ->
            booleanMultiple[which] = true;
        }
        val dialog = constructor.create()
        dialog.show()
    }

    fun showAlertDialogPersonalizado() {
        val customLayout: View =
            layoutInflater.inflate(R.layout.alertdialogpersonalizado, null)
        val constructor = AlertDialog.Builder(this)
        constructor.setTitle("Personalizado")
        val firstInput = customLayout.findViewById<EditText>(R.id.TNombre)
        val secondInput =
            customLayout.findViewById<EditText>(R.id.TPassword)
        constructor.setPositiveButton("ok") { dialogInterface, i ->
            var nombre = firstInput.text.toString()
            var password = secondInput.text.toString()
            Toast.makeText(this, "ok presionado", Toast.LENGTH_LONG).show()
        }
        constructor.setNegativeButton("no ok") { dialogInterface, i ->
            Toast.makeText(this, "no ok presionado", Toast.LENGTH_LONG).show()
        }
        constructor.setView(customLayout)
        val dialog = constructor.create();
        dialog.show()
    }

    private fun ShowDatePicker() {
        val DatePickerFragment = DatePicker()
        DatePickerFragment.show(supportFragmentManager, "datePicker")
    }

    override fun onDateSet(view: android.widget.DatePicker?, year: Int, month: Int, day: Int) {
        val timeselected = String.format("%02d/%02d/%02d", year, month + 1, day)
        binding.tFecha.setText(timeselected)
    }

    private fun showTimePicker() {
        val timePickerFragment = TimePickerFragment()
        timePickerFragment.show(supportFragmentManager, "timePicker")
    }
    override fun onTimeSelected(hourOfDay: Int, minute: Int) {
        // Mostrar la hora seleccionada en el EditText
        val timeSelected = String.format("%02d:%02d", hourOfDay, minute)
        binding.tHora.setText(timeSelected)
    }
}