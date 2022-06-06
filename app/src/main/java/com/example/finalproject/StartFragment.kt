package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.finalproject.databinding.FragmentMainBinding
import com.example.finalproject.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding?=null
    private val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentStartBinding.inflate(inflater, container, false)
        val rootView=binding.root
        binding.fri.setOnClickListener{
            rootView.findNavController().navigate(R.id.action_startFragment_to_myFridgeFragment)
        }
        binding.ing.setOnClickListener{
            rootView.findNavController().navigate(R.id.action_startFragment_to_fridgeFragment)
        }
        binding.button.setOnClickListener{
            rootView.findNavController().navigate(R.id.action_startFragment_to_cuisineFragment)
        }
        return binding.root
    }

}