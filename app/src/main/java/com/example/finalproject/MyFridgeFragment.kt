package com.example.finalproject

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.cuisine.CuisineAdapter
import com.example.finalproject.databinding.FragmentCuisineBinding
import com.example.finalproject.databinding.FragmentMyFridgeBinding


var mfl= arrayListOf<String>()
class MyFridgeFragment : Fragment() {
    private var _binding: FragmentMyFridgeBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMyFridgeBinding.inflate(inflater, container, false)
        val mAdapter= MyFridgeAdapter(mfl)
        binding.recyclerView5.adapter=mAdapter
        val rootView=binding.root
        binding.butt.setOnClickListener{
            rootView.findNavController().navigate(R.id.action_myFridgeFragment_to_fridgeFragment)
        }
        setHasOptionsMenu(true)
        return rootView
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())||super.onOptionsItemSelected(item)

    }
}