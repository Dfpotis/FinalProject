package com.example.finalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutFourBinding

class FoodAdapter(val foodList: List<Food>) : RecyclerView.Adapter<FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ListItemLayoutFourBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(currentViewHolder: FoodViewHolder, position: Int) {
        val currentCourse = foodList[position]
        currentViewHolder.bindFood(currentCourse)

    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}