package com.example.finalproject

import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutBinding

class RecipeViewHolder(val binding:ListItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentRecipe: Recipe

    fun bindIngredient(recipe: Recipe){
        currentRecipe=recipe
        binding.


    }

}