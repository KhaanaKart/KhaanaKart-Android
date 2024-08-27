package com.example.khaanakart.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khaanakart.MainActivity
import com.example.khaanakart.databinding.FragmentOrderPlacedSuccessBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class OrderPlacedSuccessBottomSheetFragment: BottomSheetDialogFragment() {

    private val binding: FragmentOrderPlacedSuccessBottomSheetBinding by lazy {
        FragmentOrderPlacedSuccessBottomSheetBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.goHomeButton.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {

    }
}