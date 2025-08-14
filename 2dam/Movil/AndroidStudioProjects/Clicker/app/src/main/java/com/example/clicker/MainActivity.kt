package com.example.clicker

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.muestra.text = count.toString()

        binding.button.setOnClickListener {
            count++
            setCount()
        }
        binding.button2.setOnClickListener {
            if (count > 0) {
                count--

            }
            setCount()
        }


    }

    private fun setCount() {
        binding.muestra.text = count.toString()

    }
}