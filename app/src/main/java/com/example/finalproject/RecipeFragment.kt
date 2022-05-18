package com.example.finalproject

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.FragmentMainBinding


class RecipeFragment : Fragment() {
    private var _binding: FragmentMainBinding?=null
    private val binding get()=_binding!!

    private val viewModel: RecipeViewModel by viewModels()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentMainBinding.inflate(inflater, container, false)
        viewModel.getRecipes()
        viewModel.response.observe(viewLifecycleOwner, Observer { recipeList ->
            val adapter= RecipeAdapter(recipeList)
            binding.recyclerView.adapter=adapter
        })
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
