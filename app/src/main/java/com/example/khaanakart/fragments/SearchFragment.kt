package com.example.khaanakart.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khaanakart.R
import com.example.khaanakart.adapters.MenuAdapter
import com.example.khaanakart.databinding.FragmentSearchBinding
import com.example.khaanakart.models.FoodItemModel

class SearchFragment : Fragment() {

    private val binding: FragmentSearchBinding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
    }

    private val foodList = mutableListOf(
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

    private val filteredFoodList = mutableListOf<FoodItemModel>()

    private var adapter: MenuAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MenuAdapter(filteredFoodList, requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.searchMenuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.searchMenuRecyclerView.adapter = adapter

        // function for the search view
        setupSearchView()

        // function to show all menu items
        showAllMenuItems()

        return binding.root
    }

    private fun showAllMenuItems() {
        filteredFoodList.clear()
        filteredFoodList.addAll(foodList)

        adapter?.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filteredFoodList.clear()

        foodList.forEachIndexed { _, food ->
            if(food.name.contains(query, ignoreCase = true)) {
                filteredFoodList.add(food)
            }
        }

        adapter?.notifyDataSetChanged()
    }

    companion object {

    }
}