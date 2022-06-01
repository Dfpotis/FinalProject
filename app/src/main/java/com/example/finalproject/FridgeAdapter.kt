package com.example.finalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import com.example.finalproject.databinding.ListItemLayoutThreeBinding

class FridgeAdapter(val fridgeList: List<Fridge>) : RecyclerView.Adapter<FridgeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FridgeViewHolder {
        val binding = ListItemLayoutThreeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FridgeViewHolder(binding)
    }

    override fun onBindViewHolder(currentViewHolder: FridgeViewHolder, position: Int) {
        var num=0
        while(num< aisleList.size)
        if(fridgeList[position].aisle.equals(aisleList[num])) {
            num+= aisleList.size+10
        }
        else if(num==aisleList.size-1){
            val currentCourse = fridgeList[position]
            currentViewHolder.bindFridge(currentCourse)
        }
        else{
            num++
        }
    }

    override fun getItemCount(): Int {
        return fridgeList.size
    }
}
