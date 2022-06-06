package com.example.finalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutFiveBinding
import com.example.finalproject.databinding.ListItemLayoutTwoBinding

class MyFridgeAdapter (val mList: List<String>) : RecyclerView.Adapter<MyFridgeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFridgeViewHolder {
        val binding = ListItemLayoutFiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyFridgeViewHolder(binding)
    }

    override fun onBindViewHolder(currentViewHolder: MyFridgeViewHolder, position: Int) {
        val currentCuisine = mList[position]
        currentViewHolder.bindF(currentCuisine)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}