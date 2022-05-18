package com.example.finalproject

import com.squareup.moshi.Json

class FridgeResponse {
    @Json(name="results")
    lateinit var fridgeResponseList:List<FridgeResults>
}
class FridgeResults {
    @Json(name = "extendedIngredients")
    lateinit var extendedIngredientsList:List<Ingredients>

}
class Ingredients{
    @Json(name="aisle")
    lateinit var aisle:String

    @Json(name="name")
    lateinit var name:String
}

