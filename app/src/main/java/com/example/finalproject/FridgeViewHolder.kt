package com.example.finalproject


import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutBinding
import com.example.finalproject.databinding.ListItemLayoutThreeBinding
var p=""
val aisleList= arrayListOf<Fridge>(Fridge("",""))
class FridgeViewHolder(val binding: ListItemLayoutThreeBinding) :
        RecyclerView.ViewHolder(binding.root) {
    val rootview=binding.root
    private lateinit var currentFridge: Fridge
        fun bindFridge(fridge: Fridge){
            currentFridge=fridge
            binding.aisle.text=currentFridge.aisle
        }

    init{
        rootview.setOnClickListener{
            p=currentFridge.aisle.toString()
            abcdefgList=arrayListOf<Food>(Food("","",""))
            rootview.findNavController().navigate(R.id.action_fridgeFragment_to_foodFragment)


        }

    }

    }