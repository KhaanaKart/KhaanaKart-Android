package com.example.khaanakart.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khaanakart.R
import com.example.khaanakart.adapters.CartAdapter
import com.example.khaanakart.databinding.FragmentCartBinding
import com.example.khaanakart.models.CartItemModel

class CartFragment : Fragment() {

    private val binding: FragmentCartBinding by lazy {
        FragmentCartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cartList = listOf(
            CartItemModel("Burger", 8.99, R.drawable.burger, 1),
            CartItemModel("Sandwich", 6.99, R.drawable.sandwich, 2),
            CartItemModel("Chow Mein", 11.99, R.drawable.chowmein, 1),
            CartItemModel("Salad", 8.99, R.drawable.salad, 1),
            CartItemModel("Samosa", 4.99, R.drawable.samosa, 10),
            CartItemModel("Omelette", 7.99, R.drawable.omelette, 3)
        )

        val adapter = CartAdapter(cartList.toMutableList())
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
    }

    companion object {

    }
}