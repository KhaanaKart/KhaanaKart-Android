package com.example.khaanakart.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.khaanakart.R
import com.example.khaanakart.adapters.PopularFoodsAdapter
import com.example.khaanakart.databinding.FragmentHomeBinding
import com.example.khaanakart.models.PopularFoodItem

class HomeFragment : Fragment() {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
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

        val bannerList = ArrayList<SlideModel>()
        bannerList.add(SlideModel(R.drawable.food_banner_1))
        bannerList.add(SlideModel(R.drawable.food_banner_2))
        bannerList.add(SlideModel(R.drawable.food_banner_3))
        bannerList.add(SlideModel(R.drawable.food_banner_4))
        bannerList.add(SlideModel(R.drawable.food_banner_5))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(bannerList, ScaleTypes.CENTER_CROP)

        imageSlider.setItemClickListener(object: ItemClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemMessage = "Selected Image $position"

                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }

        })

        val foodList = listOf(
            PopularFoodItem("Burger", 8.99, R.drawable.burger),
            PopularFoodItem("Sandwich", 6.99, R.drawable.sandwich),
            PopularFoodItem("Chow Mein", 11.99, R.drawable.chowmein),
            PopularFoodItem("Salad", 8.99, R.drawable.salad),
            PopularFoodItem("Samosa", 4.99, R.drawable.samosa),
            PopularFoodItem("Omelette", 7.99, R.drawable.omelette)
        )

        val adapter = PopularFoodsAdapter(foodList)
        binding.popularFoodsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularFoodsRecyclerView.adapter = adapter
    }

    companion object {

    }
}