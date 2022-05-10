package com.example.finalproject.cuisine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.Cuisine
import com.example.finalproject.CuisineViewHolder
import com.example.finalproject.databinding.ListItemLayoutBinding

class CuisineAdapter (val cuisineList: List<Cuisine>) : RecyclerView.Adapter<CuisineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuisineViewHolder {
        val binding = ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CuisineViewHolder(binding)
    }

    override fun onBindViewHolder(currentViewHolder: CuisineViewHolder, position: Int) {
        val currentCuisine = cuisineList[position]
        currentViewHolder.bindCuisine(currentCuisine)
    }

    override fun getItemCount(): Int {
        return cuisineList.size
    }
}