package com.example.khaanakart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khaanakart.R
import com.example.khaanakart.adapters.MenuAdapter
import com.example.khaanakart.databinding.FragmentMenuBottomSheetBinding
import com.example.khaanakart.models.FoodItemModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private val binding: FragmentMenuBottomSheetBinding by lazy {
        FragmentMenuBottomSheetBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.backButton.setOnClickListener {
            dismiss()
        }

        val foodList = listOf(
            FoodItemModel("Burger", 8.99, R.drawable.burger),
            FoodItemModel("Sandwich", 6.99, R.drawable.sandwich),
            FoodItemModel("Chow Mein", 11.99, R.drawable.chowmein),
            FoodItemModel("Salad", 8.99, R.drawable.salad),
            FoodItemModel("Samosa", 4.99, R.drawable.samosa),
            FoodItemModel("Omelette", 7.99, R.drawable.omelette),
            FoodItemModel("Pizza", 12.99, R.drawable.pizza),
            FoodItemModel("Pasta", 10.99, R.drawable.pasta),
            FoodItemModel("Chicken Wings", 9.99, R.drawable.chicken_wings),
            FoodItemModel("Quesadilla", 7.99, R.drawable.quesadilla),
            FoodItemModel("Spring Rolls", 5.99, R.drawable.spring_roll),
            FoodItemModel("Tacos", 8.99, R.drawable.taco),
            FoodItemModel("Smoothie", 5.49, R.drawable.smoothie),
            FoodItemModel("Brownie", 3.99, R.drawable.brownie),
            FoodItemModel("Fries", 4.49, R.drawable.french_fries),
            FoodItemModel("Waffle", 4.99, R.drawable.waffle),
            FoodItemModel("Hot Dog", 6.49, R.drawable.hot_dog)
        )

        val adapter = MenuAdapter(foodList, requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        return binding.root
    }

    companion object {

    }
}