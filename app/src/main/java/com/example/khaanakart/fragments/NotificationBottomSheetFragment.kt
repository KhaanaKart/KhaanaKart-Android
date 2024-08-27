package com.example.khaanakart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khaanakart.R
import com.example.khaanakart.adapters.NotificationAdapter
import com.example.khaanakart.databinding.FragmentNotificationBottomSheetBinding
import com.example.khaanakart.models.NotificationItemModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NotificationBottomSheetFragment : BottomSheetDialogFragment() {

    private val binding: FragmentNotificationBottomSheetBinding by lazy {
        FragmentNotificationBottomSheetBinding.inflate(layoutInflater)
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

        val notificationsList = listOf(
            NotificationItemModel("Your order has been cancelled! Sorry for the inconvenience", R.drawable.cancel_circle),
            NotificationItemModel("Your order is out for delivery", R.drawable.local_shipping),
            NotificationItemModel("Congrats! Your order is placed", R.drawable.check_circle)
        )

        val adapter = NotificationAdapter(notificationsList)
        binding.notificationsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationsRecyclerView.adapter = adapter

        return binding.root
    }

    companion object {

    }
}