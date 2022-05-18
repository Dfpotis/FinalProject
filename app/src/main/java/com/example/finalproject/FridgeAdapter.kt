package com.example.finalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutBinding

class FridgeAdapter(val fridgeList: List<Fridge>) : RecyclerView.Adapter<FridgeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FridgeViewHolder {
        val binding = ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FridgeViewHolder(binding)
    }

    override fun onBindViewHolder(currentViewHolder: FridgeViewHolder, position: Int) {
        val currentCourse = fridgeList[position]
        currentViewHolder.bindFridge(currentCourse)
    }

    override fun getItemCount(): Int {
        return fridgeList.size
    }
}
