package com.example.finalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutBinding

class RecipeAdapter(val recipeList: List<Recipe>) : RecyclerView.Adapter<RecipeViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
            val binding = ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RecipeViewHolder(binding)
        }

        override fun onBindViewHolder(currentViewHolder: RecipeViewHolder, position: Int) {
            val currentCourse = recipeList[position]
            currentViewHolder.bindIngredient(currentCourse)
        }

        override fun getItemCount(): Int {
            return recipeList.size
        }
    }



