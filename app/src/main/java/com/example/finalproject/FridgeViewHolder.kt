package com.example.finalproject


import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutBinding
import com.example.finalproject.databinding.ListItemLayoutThreeBinding

val aisleList= arrayListOf<String?>("")
class FridgeViewHolder(val binding: ListItemLayoutThreeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var num=0
        private lateinit var currentFridge: Fridge
        fun bindFridge(fridge: Fridge){
            currentFridge=fridge
            var aisleName=""
            var abc=""

            val aisleSpot = currentFridge.aisle?.indexOf(";")
            if (aisleSpot != null) {
                if(aisleSpot>0){
                    aisleName= currentFridge.aisle?.substring(0,aisleSpot) ?:""
                }
                else {
                    aisleName = currentFridge.aisle.toString()
                }
            }
           while(aisleList.size>num){
               if(aisleList[num].equals(aisleName)){
                   num=aisleList.size+10
               }
             else if(num==aisleList.size-1){

                 abc=aisleName
                   aisleList.add(aisleList.size,aisleName)
                   num+=9
               }
               else{
                   num++
               }
           }
            num=0
                binding.aisle.text = abc + aisleList.indexOf(aisleName)
        }
    }