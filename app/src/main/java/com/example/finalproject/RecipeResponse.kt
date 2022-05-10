package com.example.finalproject

import com.squareup.moshi.Json

class RecipeResponse {
    @Json(name="results")
    lateinit var recipeResponseList:List<RecipeResults>
}
class RecipeResults{
    @Json(name="title")
    lateinit var title:String

    @Json(name="summary")
    lateinit var summary:String

    @Json(name="readyInMinutes")
    lateinit var time:String

    @Json(name="analyzedInstructions")
    lateinit var analyzedInstructionsList:List<Steps>

    @Json(name="image")
    lateinit var image:String
}
class Steps{
    @Json(name="step")
    lateinit var step:String
}