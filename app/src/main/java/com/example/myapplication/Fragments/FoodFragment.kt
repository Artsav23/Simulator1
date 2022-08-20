package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.Main.MainActivityViewModel
import com.example.myapplication.databinding.FragmentFoodBinding

class FoodFragment : Fragment() {

    private lateinit var binding: FragmentFoodBinding
    private val fragmentViewModel = FragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentFoodBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.eatWithTheGarbage.setOnClickListener {
            fragmentViewModel.action(1..3, 0..0, -3..-1, context)
        }

        binding.eatHotdog.setOnClickListener {
            fragmentViewModel.action(4..6, -5..-5, 0..0, context)
        }

        binding.eatPizza.setOnClickListener {
            fragmentViewModel.action(6..10, -10..-10, 0..0, context)
        }

        binding.goToTheCafe.setOnClickListener {
            if (!MainActivityViewModel.Count.normalClothes) {
                Toast.makeText(activity, "In this costume you not let in cafe", Toast.LENGTH_SHORT).show()
            }
            else {
                fragmentViewModel.action(10..15, -20..-20, null, context)
            }
        }
    }
}