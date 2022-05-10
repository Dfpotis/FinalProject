package com.example.finalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.Recipe
import com.example.finalproject.RecipeApi
import com.example.finalproject.RecipeResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class RecipeViewModel:ViewModel() {
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
                val recipeResponse: RecipeResponse?=response.body()
                val recipeResponseList=recipeResponse?.recipeResponseList?:listOf()
                for(recipeResults in recipeResponseList) {
                    val desc=recipeResults.summary
                    val title=recipeResults.title
                    val image=recipeResults.image
                    val newRecipe= Recipe(desc, title,image)
                    listOfRecipesFetched.add(newRecipe)
                }
                _response.value=listOfRecipesFetched
            }
        })
    }
}