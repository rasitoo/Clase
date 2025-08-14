package com.example.examenrodrigotapiador

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.examenrodrigotapiador.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //creamos un objeto navHostFragment para mostrar los destinos
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        //asociamos el navController al navHostFragment
        navController = navHostFragment.navController

        // navController = findNavController(R.id.fragmentContainerView)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        //conectamos el bottomNavigation con navController
        setupWithNavController(bottomNavigation, navController)
    }

}
