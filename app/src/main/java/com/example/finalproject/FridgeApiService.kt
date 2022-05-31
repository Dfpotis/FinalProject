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
        "?apiKey=7b93c4ebc9d1403f9b9bc69cac84b502"+
        "&instructionsRequired=true"+
        "&addRecipeInformation=true"+
        "&number=5"+
        "&type=mainCourse"+
        "&fillIngredients=true"





interface FridgeApiService {
    @GET(QUERRY_STRING)
    fun getFridge(): Call<FridgeResponse>
}
object FridgeApi {
    val fridgeApi: FridgeApiService by lazy {
        retrofit.create(FridgeApiService::class.java)
    }
}