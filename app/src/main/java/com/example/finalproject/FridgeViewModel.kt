package com.example.finalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class FridgeViewModel: ViewModel() {
    private val _response= MutableLiveData<List<Fridge>>()
    val response: LiveData<List<Fridge>>
        get()=_response
    fun getFridge(){
        val request= FridgeApi.fridgeApi.getFridge()
        request.enqueue(object: Callback<FridgeResponse> {
            override fun onFailure(call: Call<FridgeResponse>, t: Throwable) {
                Log.d("RESPONSE", "Failure: " + t.message)
            }
            override fun onResponse(call: Call<FridgeResponse>, response: Response<FridgeResponse>){
                Log.d("RESPONSE", "Sucsess")
                var listOfFridgeFetched=mutableListOf<Fridge>()
                val fridgeResponse: FridgeResponse?=response.body()
                val fridgeResponseList=fridgeResponse?.fridgeResponseList?:listOf()
                for(fridgeResults in fridgeResponseList){
                    val extendedIngredientsList=fridgeResults.extendedIngredientsList
                    for(ingredients in extendedIngredientsList){
                        val title=ingredients.name
                        val aisle=ingredients.aisle
                        val newFridge= Fridge(title, aisle)
                        listOfFridgeFetched.add(newFridge)
                    }
                }
                _response.value=listOfFridgeFetched
            }
        })
    }
}