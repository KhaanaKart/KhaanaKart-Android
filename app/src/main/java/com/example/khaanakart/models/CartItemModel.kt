package com.example.khaanakart.models

data class CartItemModel(
    val name: String,
    val price: Double,
    val imageResId: Int,
    var quantity: Int
)
