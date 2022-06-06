package com.example.finalproject

import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutFiveBinding
import com.example.finalproject.databinding.ListItemLayoutThreeBinding

class MyFridgeViewHolder(val binding: ListItemLayoutFiveBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindF(word: String) {
        binding.k.text=word

    }
}