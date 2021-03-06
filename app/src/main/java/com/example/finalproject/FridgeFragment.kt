package com.example.finalproject

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer


import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import com.example.finalproject.databinding.FragmentOptionsBinding


class FridgeFragment : Fragment() {
    private var _binding: FragmentOptionsBinding? = null
    private val binding get() = _binding!!
    private val viewModel:FridgeViewModel by viewModels()
    var number=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentOptionsBinding.inflate(inflater, container, false)
        viewModel.getFridge()

        viewModel.response.observe(viewLifecycleOwner, Observer { fridgeList ->

            while(fridgeList.size>number) {
                val aisleSpot= fridgeList[number].aisle?.indexOf(";")
                var aisleName=""
                if (aisleSpot != null) {
                    if(aisleSpot>0){
                        aisleName= fridgeList[number].aisle?.substring(0,aisleSpot) ?:""
                    }
                    else {
                        aisleName = fridgeList[number].aisle.toString()
                    }
                }
                fridgeList[number].aisle=aisleName
                var num=0
                while(aisleList.size>num){
                    if(aisleList[num].aisle.equals(fridgeList[number].aisle)){
                        num= aisleList.size+10
                    }
                    else if(num== aisleList.size-1){
                        aisleList.add(aisleList.size-1,fridgeList[number])
                    }
                    else{
                        num++
                    }
                }
                number++
            }
            val adapter = FridgeAdapter(aisleList)
            binding.recyclerView3.adapter = adapter
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