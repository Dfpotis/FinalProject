package com.example.finalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeViewModel {
    private val _response= MutableLiveData<List<Recipe>>()
    val response: LiveData<List<Recipe>>
        get()=_response
    fun getRecipes(){
        val request= RecipeApi.recipeApi.getRecipes()
        request.enqueue(object: Callback<RecipeResponse>{
            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                Log.d("RESPONSE", "Failure: " + t.message)
            }
            override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>){
                var listOfRecipesFetched=mutableListOf<Recipe>()
                val recipeResponse:RecipeResponse?=response.body()
                val recipeResponseList=recipeResponse?.recipeResponseList?:listOf()
                for(recipeResults in recipeResponseList) {
                    val desc=recipeResults.summary
                    val title=recipeResults.title
                    val newRecipe=Recipe(desc, title)
                    listOfRecipesFetched.add(newRecipe)
                }
                _response.value=listOfRecipesFetched
            }
        })
    }
}