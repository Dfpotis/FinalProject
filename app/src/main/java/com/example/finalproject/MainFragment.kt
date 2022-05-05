package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import androidx.lifecycle.Observer
import com.example.finalproject.databinding.FragmentMainBinding




class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding?=null
    private val binding get()=_binding!!

    private val viewModel: RecipeViewModel by viewModels()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentMainBinding.inflate(inflater, container, false)
        viewModel.getRecipes()
        viewModel.response.observe(viewLifecycleOwner, Observer { recipeList ->
            val adapter=RecipeAdapter(recipeList)
            binding.recyclerView.adapter=adapter
        })
        return binding.root
    }
}
