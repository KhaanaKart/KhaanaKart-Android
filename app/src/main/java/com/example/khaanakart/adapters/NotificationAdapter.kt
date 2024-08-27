package com.example.khaanakart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.khaanakart.databinding.NotificationListItemBinding
import com.example.khaanakart.models.NotificationItemModel

class NotificationAdapter(private val notificationsList: List<NotificationItemModel>): RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(NotificationListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return notificationsList.size
    }

    inner class NotificationViewHolder(private val binding: NotificationListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                notificationName.text = notificationsList[position].name
                notificationImage.setImageResource(notificationsList[position].imageResId)
            }
        }

    }
}