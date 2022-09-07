package com.example.myapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.Information
import com.example.myapplication.databinding.FragmentFoodBinding

class FoodFragment : BaseFragment() {

    private lateinit var binding: FragmentFoodBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFoodBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHotDogAction()
        setPizzaAction()
        setGarbageAction()
        cafeAction()
    }

    private fun setGarbageAction() {
        binding.eatWithTheGarbage.setOnClickListener {
            action(foodRange = 1..3, money = 0..0, mood = -3..-1, context)
        }
    }

    private fun setHotDogAction() {
        binding.eatHotdog.setOnClickListener {
            action(foodRange = 4..6, money = -5..-5, mood = 0..0, context)
        }
    }

    private fun setPizzaAction() {
        binding.eatPizza.setOnClickListener {
            action(foodRange = 6..10, money = -10..-10, mood = 0..0, context)
        }
    }

    private fun cafeAction() {
        binding.goToTheCafe.setOnClickListener {
            if (!Information.normalClothes) {
                Toast.makeText(activity, "In this costume you not let in cafe", Toast.LENGTH_SHORT).show()
            }
            else {
                action(10..15, -20..-20, 0..0, context)
            }
        }
    }
}