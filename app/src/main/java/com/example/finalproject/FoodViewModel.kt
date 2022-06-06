package com.example.finalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class FoodViewModel: ViewModel() {
    private val _response = MutableLiveData<List<Food>>()
    val response: LiveData<List<Food>>
        get() = _response

    fun getFood() {
        val request = FoodApi.foodApi.getFood()
        request.enqueue(object : Callback<FoodResponse> {
            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                Log.d("RESPONSE", "Failure: " + t.message)
            }

            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
                Log.d("RESPONSE", "Sucsess")
                var listOfFoodFetched = mutableListOf<Food>()
                val foodResponse: FoodResponse? = response.body()
                val fridgeResponseList = foodResponse?.fridgeResponseList ?: listOf()
                for (foodResults in fridgeResponseList) {
                    val extendedIngredientsList = foodResults.extendedIngredientsList
                    for (ingredients in extendedIngredientsList) {
                        val title = ingredients.name
                        val aisle = ingredients.aisle
                        val newAisle = Food(title, "false", aisle)
                        listOfFoodFetched.add(newAisle)
                    }
                }
                _response.value = listOfFoodFetched

            }
        })
    }
}
