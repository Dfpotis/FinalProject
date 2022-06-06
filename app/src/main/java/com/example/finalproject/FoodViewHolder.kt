package com.example.finalproject

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.FragmentFoodBinding
import com.example.finalproject.databinding.ListItemLayoutFourBinding
import com.google.android.material.snackbar.Snackbar
var checklist= arrayListOf<String>()
var abcdefgList= arrayListOf<Food>(Food("","",""))
class FoodViewHolder(val binding: ListItemLayoutFourBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentFood: Food
    fun bindFood(food: Food){
        currentFood=food
       if(checklist.contains(currentFood.title)){
           binding.check.isChecked=true
       }
        binding.aisle.text=currentFood.title
        binding.check.setOnClickListener {
            if(binding.check.isChecked) {
                mfl.add(currentFood.title.toString())
                checklist.add(currentFood.title.toString())
                Snackbar.make(
                    binding.snack,
                    currentFood.title + " added to fridge",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
            else{
                mfl.remove(currentFood.title.toString())
                checklist.remove(currentFood.title.toString())
                Snackbar.make(
                    binding.snack,
                    currentFood.title + " removed from fridge",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

}