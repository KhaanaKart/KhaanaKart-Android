package com.example.khaanakart

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.khaanakart.databinding.ActivityMainBinding
import com.example.khaanakart.fragments.NotificationBottomSheetFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val navController = findNavController(R.id.fragmentContainerView)
        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavBar.setupWithNavController(navController)

        binding.notificationsButton.setOnClickListener {
            val notificationsBottomSheetDialog = NotificationBottomSheetFragment()
            notificationsBottomSheetDialog.show(supportFragmentManager, null)
        }
    }
}