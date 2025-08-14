package com.example.practicaestadointentdialog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaestadointentdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val intent = Intent(this, ActivityIntent::class.java)
            intent.putExtra("key_t", binding.editTextText.text.toString())
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Mensaje", "Estoy onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Mensaje", "Estoy onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.i("Mensaje", "Estoy onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.i("Mensaje", "Estoy onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Mensaje", "Estoy onDestroy")

    }
}
