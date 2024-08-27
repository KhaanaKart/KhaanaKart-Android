package com.example.khaanakart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.khaanakart.adapters.CartAdapter.*
import com.example.khaanakart.databinding.CartListItemBinding
import com.example.khaanakart.models.CartItemModel

class CartAdapter(private val cartList: MutableList<CartItemModel>): RecyclerView.Adapter<CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(CartListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    inner class CartViewHolder(private val binding: CartListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                foodName.text = cartList[position].name
                foodTotalPrice.text = cartList[position].price.toString()
                foodImage.setImageResource(cartList[position].imageResId)
                quantityText.text = cartList[position].quantity.toString()
            }

            binding.reduceItemButton.setOnClickListener {
                decreaseQuantity(position)
            }

            binding.addItemButton.setOnClickListener {
                increaseQuantity(position)
            }

            binding.removeItemButton.setOnClickListener {
                val itemPosition = adapterPosition
                if (itemPosition != RecyclerView.NO_POSITION) {
                    deleteItem(itemPosition)
                }
            }
        }

        private fun decreaseQuantity(position: Int) {
            if (cartList[position].quantity > 1) {
                cartList[position].quantity--
                binding.quantityText.text = cartList[position].quantity.toString()
            }
        }

        private fun increaseQuantity(position: Int) {
            if (cartList[position].quantity < 10) {
                cartList[position].quantity++
                binding.quantityText.text = cartList[position].quantity.toString()
            }
        }

        private fun deleteItem(position: Int) {
            cartList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartList.size)
        }
    }


}