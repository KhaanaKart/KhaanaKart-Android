package com.example.khaanakart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.khaanakart.adapters.MenuAdapter.MenuViewHolder
import com.example.khaanakart.databinding.FoodListItemBinding
import com.example.khaanakart.models.FoodItemModel

class MenuAdapter(private val foodList: List<FoodItemModel>): RecyclerView.Adapter<MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(FoodListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val foodItem = foodList[position]
        val name = foodItem.name
        val price = "$${foodItem.price}"
        val image = foodItem.imageResId
        holder.bind(name, price, image)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }


    inner class MenuViewHolder(private val binding: FoodListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String, price: String, image: Int) {
            binding.foodNamePopular.text = name
            binding.foodPricePopular.text = price
            binding.foodImagePopular.setImageResource(image)
        }
    }
}