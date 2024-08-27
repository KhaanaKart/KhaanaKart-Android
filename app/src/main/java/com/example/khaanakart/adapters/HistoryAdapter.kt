package com.example.khaanakart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.khaanakart.databinding.HistoryListItemBinding
import com.example.khaanakart.models.FoodItemModel

class HistoryAdapter(private val foodList: MutableList<FoodItemModel>): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(HistoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val foodItem = foodList[position]
        val name = foodItem.name
        val price = "$${foodItem.price}"
        val image = foodItem.imageResId
        holder.bind(name, price, image)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class HistoryViewHolder(private val binding: HistoryListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String, price: String, image: Int) {
            binding.historyFoodName.text = name
            binding.historyFoodPrice.text = price
            binding.historyFoodImage.setImageResource(image)
        }

    }
}