package com.example.finalproject

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private const val BASE_URL="https://api.spoonacular.com/recipes/"
private val retrofit= Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
private const val QUERRY_STRING= "complexSearch"+
        "?apiKey=85000ea0e096460295bf7d666f8b647e"+
        "&instructionsRequired=true"+
        "&addRecipeInformation=true"+
        "&number=5"+
        "&type=mainCourse"+
        "&fillIngredients=true"





interface FoodApiService {
    @GET(QUERRY_STRING)
    fun getFood(): Call<FoodResponse>
}
object FoodApi {
    val foodApi: FoodApiService by lazy {
        retrofit.create(FoodApiService::class.java)
    }
}