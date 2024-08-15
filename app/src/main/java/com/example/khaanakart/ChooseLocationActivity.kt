package com.example.khaanakart

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.khaanakart.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {

    private val binding: ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val locationList: Array<String> = arrayOf("Noida", "Greater Noida", "New Delhi", "Gurugram", "Faridabad", "Ghaziabad")
        val adapter = ArrayAdapter(this, R.layout.dropdown_list_item, locationList)
        val autoCompleteTextView = binding.autoCompleteLocationList
        autoCompleteTextView.setAdapter(adapter)

    }
}