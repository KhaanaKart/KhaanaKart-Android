package com.example.khaanakart

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.khaanakart.databinding.ActivityCheckoutBinding
import com.example.khaanakart.fragments.OrderPlacedSuccessBottomSheetFragment

class CheckoutActivity : AppCompatActivity() {

    private val binding: ActivityCheckoutBinding by lazy {
        ActivityCheckoutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.placeOrderButton.setOnClickListener {
            val orderPlacedSuccessBottomSheetFragment = OrderPlacedSuccessBottomSheetFragment()
            orderPlacedSuccessBottomSheetFragment.show(supportFragmentManager, null)
        }

        binding.backButton.setOnClickListener {
            this.finish()
        }

    }
}