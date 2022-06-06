package com.example.finalproject

import com.squareup.moshi.Json

    class FoodResponse {
        @Json(name="results")
        lateinit var fridgeResponseList:List<FridgeResults>
    }
    class FoodResults {
        @Json(name = "extendedIngredients")
        lateinit var extendedIngredientsList:List<Ingredients>

    }
    class FoodIngredients{
        @Json(name="aisle")
        var aisle:String?="misc"

        @Json(name="name")
        lateinit var name:String
    }
