package com.example.finalproject


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private const val BASE_URL="https://api.spoonacular.com/recipes/"
private val retrofit= Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
private const val QUERY_STRING=
    "complexSearch"+
    "?apiKey=85000ea0e096460295bf7d666f8b647e"+
            "&cuisine=italian"+
            "&instructionsRequired=true"+
            "&addRecipeInformation=true"+
            "&number=10"+
            "&type=mainCourse"
interface RecipeApiService {
    @GET(QUERY_STRING)
    fun getRecipes(): Call<RecipeResponse>
}
object RecipeApi {
    val recipeApi: RecipeApiService by lazy {
        retrofit.create(RecipeApiService::class.java)
    }
}