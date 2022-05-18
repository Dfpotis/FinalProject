package com.example.finalproject

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.FragmentCuisineBinding
import com.example.finalproject.databinding.FragmentMainBinding
import com.example.finalproject.databinding.FragmentOptionsBinding


class FridgeFragment : Fragment() {
    private var _binding: FragmentOptionsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FridgeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentOptionsBinding.inflate(inflater, container, false)
        viewModel.getFridge()
        viewModel.response.observe(viewLifecycleOwner, Observer { fridgeList ->
            val adapter= FridgeAdapter(fridgeList )
            binding.recyclerView2.adapter=adapter
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)

    }
}