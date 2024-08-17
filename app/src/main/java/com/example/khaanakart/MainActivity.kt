package com.example.khaanakart

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var NavController = findNavController(R.id.fragmentContainerView)
        var bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavBar.setupWithNavController(NavController)
    }
}