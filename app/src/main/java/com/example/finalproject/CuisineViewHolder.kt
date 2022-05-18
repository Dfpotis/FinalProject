package com.example.finalproject

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutTwoBinding
const val cuisineURL="italian"

class CuisineViewHolder (val binding: ListItemLayoutTwoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val rootview=binding.root
    private lateinit var currentCuisine: Cuisine

    fun bindCuisine(cuisine: Cuisine){
        currentCuisine=cuisine
        binding.title.text=currentCuisine.text
        if(cuisineURL=="Italian"){

        }

    }
    init{
        rootview.setOnClickListener{

            rootview.findNavController().navigate(R.id.action_cuisineFragment_to_mainFragment)
        }

    }
}