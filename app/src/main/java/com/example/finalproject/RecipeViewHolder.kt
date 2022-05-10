package com.example.finalproject

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutBinding
import com.example.finalproject.Recipe
import java.util.concurrent.Executors

class RecipeViewHolder(val binding:ListItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentRecipe: Recipe

    fun bindIngredient(recipe: Recipe) {
        currentRecipe = recipe
        binding.title.text = currentRecipe.title
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap? = null
        executor.execute {
            try {
                val `in` = java.net.URL(currentRecipe.image).openStream()
                image = BitmapFactory.decodeStream(`in`)
                handler.post {
                    binding.imageView.setImageBitmap(image)
                }
           } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    }
