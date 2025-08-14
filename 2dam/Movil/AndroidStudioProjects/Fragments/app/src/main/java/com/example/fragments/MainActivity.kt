package com.example.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.fragments.databinding.ActivityMainBinding
import androidx.fragment.app.commit;
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { irFragmento1() }
        binding.button2.setOnClickListener { irFragmento2() }
        binding.button3.setOnClickListener { irFragmento3() }
        getSupportFragmentManager()

    }

    private fun irFragmento3() {
        supportFragmentManager.commit{
            replace<BlankFragment3>(R.id.fragmentContainerView)
            setReorderingAllowed(true)
            addToBackStack("tercero")
        }
    }

    private fun irFragmento2() {
        supportFragmentManager.commit{
            replace<BlankFragment2>(R.id.fragmentContainerView)
            setReorderingAllowed(true)
            addToBackStack("segundo")
        }    }

    private fun irFragmento1() {
        supportFragmentManager.commit{
            replace<BlankFragment>(R.id.fragmentContainerView)
            setReorderingAllowed(true)
            addToBackStack("primero")
        }    }
}