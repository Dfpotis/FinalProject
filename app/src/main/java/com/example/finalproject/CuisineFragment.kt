package com.example.finalproject

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.cuisine.CuisineAdapter

import com.example.finalproject.databinding.FragmentCuisineBinding



class CuisineFragment : Fragment() {
    private var _binding: FragmentCuisineBinding?=null
    private val binding get()=_binding!!

    val cuisineList=listOf(
        Cuisine("Italian"), Cuisine("Chinese"),
        Cuisine("German"),
        Cuisine("French"),
        Cuisine("American"),
        Cuisine("Greek"),
        Cuisine("Japanese"),
        Cuisine("Mexican"),
        Cuisine("Indian")
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentCuisineBinding.inflate(inflater, container, false)
        val mAdapter= CuisineAdapter(cuisineList)
        binding.recyclerView2.adapter=mAdapter
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())||super.onOptionsItemSelected(item)

    }
}