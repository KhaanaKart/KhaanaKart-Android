package com.example.khaanakart

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.khaanakart.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private val binding: ActivityDetailsBinding by lazy {
        ActivityDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val foodName = intent.getStringExtra("FoodItemName")
        val foodImage = intent.getIntExtra("FoodItemImage",0)

        binding.foodName.text = foodName
        binding.foodImage.setImageResource(foodImage)

        binding.backButton.setOnClickListener {
            this.finish()
        }
    }
}