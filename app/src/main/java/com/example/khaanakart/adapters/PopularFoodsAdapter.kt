package com.example.khaanakart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.khaanakart.adapters.PopularFoodsAdapter.PopularFoodsViewHolder
import com.example.khaanakart.databinding.PopularListItemBinding
import com.example.khaanakart.models.FoodItemModel

class PopularFoodsAdapter(private val foodList: List<FoodItemModel>): RecyclerView.Adapter<PopularFoodsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFoodsViewHolder {
        return PopularFoodsViewHolder(PopularListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PopularFoodsViewHolder, position: Int) {
        val foodItem = foodList[position]
        val name = foodItem.name
        val price = "$${foodItem.price}"
        val image = foodItem.imageResId
        holder.bind(name, price, image)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class PopularFoodsViewHolder(private val binding: PopularListItemBinding):  RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String, price: String, image: Int) {
            binding.foodNamePopular.text = name
            binding.foodPricePopular.text = price
            binding.foodImagePopular.setImageResource(image)
        }
    }
}