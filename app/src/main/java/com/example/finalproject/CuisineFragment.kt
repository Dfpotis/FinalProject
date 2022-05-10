package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.finalproject.cuisine.CuisineAdapter

import com.example.finalproject.databinding.FragmentCuisineBinding


val cuisineList=listOf(Cuisine("italian"), Cuisine("chinese"))
class CuisineFragment : Fragment() {
    private var _binding: FragmentCuisineBinding?=null
    private val binding get()=_binding!!
    private val viewModel: CuisineViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.getCuisines()
        viewModel.response.observe(viewLifecycleOwner, Observer { cuisineList ->
            val adapter= CuisineAdapter(cuisineList)
            binding.recyclerView.adapter=adapter
        })
        _binding= FragmentCuisineBinding.inflate(inflater, container, false)
        return binding.root
    }

}