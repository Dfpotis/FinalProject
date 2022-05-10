package com.example.finalproject

import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.Cuisine
import com.example.finalproject.databinding.ListItemLayoutBinding

class CuisineViewHolder (val binding: ListItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentCuisine: Cuisine

    fun bindCuisine(cuisine: Cuisine){
        currentCuisine=cuisine
        binding.title.text=currentCuisine.title

    }
}