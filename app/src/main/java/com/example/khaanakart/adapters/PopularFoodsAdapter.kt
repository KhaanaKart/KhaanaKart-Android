package com.example.khaanakart.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.khaanakart.DetailsActivity
import com.example.khaanakart.adapters.PopularFoodsAdapter.PopularFoodsViewHolder
import com.example.khaanakart.databinding.FoodListItemBinding
import com.example.khaanakart.models.FoodItemModel

class PopularFoodsAdapter(private val foodList: List<FoodItemModel>, private val context: Context): RecyclerView.Adapter<PopularFoodsViewHolder>() {

    private val itemClickListener: OnClickListener?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFoodsViewHolder {
        return PopularFoodsViewHolder(FoodListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PopularFoodsViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    inner class PopularFoodsViewHolder(private val binding: FoodListItemBinding):  RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position !=  RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClick(position)
                }
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("FoodItemName", foodList[position].name)
                intent.putExtra("FoodItemImage", foodList[position].imageResId)
                context.startActivity(intent)
            }
        }

        fun bind(position: Int) {
            binding.apply {
                foodNamePopular.text = foodList[position].name
                "$${foodList[position].price}".also { foodPricePopular.text = it }
                foodImagePopular.setImageResource(foodList[position].imageResId)
            }
        }
    }

    interface OnClickListener {
        fun onItemClick(position: Int)
    }
}