package com.example.finalproject


import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutBinding


class FridgeViewHolder(val binding: ListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var aisleList= listOf("",)
    var num=0
        private lateinit var currentFridge: Fridge
        fun bindFridge(fridge: Fridge){
            currentFridge=fridge
           while(aisleList.size>num){
               if(aisleList[num].equals(currentFridge.aisle)){
                   num=aisleList.size
               }
               else if(num==aisleList.size){

               }
               else{
                   num++
               }

           }
        }

    }