package com.example.finalproject

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.finalproject.databinding.FragmentFoodBinding
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI


class FoodFragment : Fragment() {
    private var _binding: FragmentFoodBinding?=null
    private val binding get()=_binding!!
    private val viewModel:FoodViewModel by viewModels()
    var number=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentFoodBinding.inflate(inflater, container, false)
        viewModel.getFood()

        viewModel.response.observe(viewLifecycleOwner, Observer { foodList ->
            while(foodList.size>number) {
                val aisleSpot= foodList[number].aisle?.indexOf(";")
                var aisleName=""
                if (aisleSpot != null) {
                    if(aisleSpot>0){
                        aisleName= foodList[number].aisle?.substring(0,aisleSpot) ?:""
                    }
                    else {
                        aisleName = foodList[number].aisle.toString()
                    }
                }
                var num=0
                while(abcdefgList.size>num){
                    if(abcdefgList[num].title.equals(foodList[number].title)  ){
                        num= abcdefgList.size+10
                    }
                    else if(num== abcdefgList.size-1&&aisleName==p){
                        abcdefgList.add(abcdefgList.size-1,foodList[number])
                    }
                    else{
                        num++
                    }
                }
                number++
            }
            abcdefgList.removeAt(abcdefgList.size-1)
            val adapter = FoodAdapter(abcdefgList)
            binding.recyclerView4.adapter = adapter
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
