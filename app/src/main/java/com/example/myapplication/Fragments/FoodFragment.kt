package com.example.myapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.Main.CharacteristicManager
import com.example.myapplication.databinding.FragmentFoodBinding

class FoodFragment(private var characteristicManager: CharacteristicManager) : BaseFragment(characteristicManager) {

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
        goCafeAction()
        goRestaurantAction()
    }

    private fun setGarbageAction() {
        binding.eatWithTheGarbage.setOnClickListener {
            garbageAction()
        }
    }

    private fun setHotDogAction() {
        binding.eatHotdog.setOnClickListener {
            hotDogAction()
        }
    }

    private fun setPizzaAction() {
        binding.eatPizza.setOnClickListener {
            pizzaAction()
        }
    }

    private fun goCafeAction() {
        binding.goToTheCafe.setOnClickListener {
            if (!characteristicManager.normalClothes) {
                setSendMessage( "In this costume you not let in cafe")
            }
            else {
                cafeAction()
            }
        }
    }

     private fun goRestaurantAction() {
        binding.goToTheRestaurant.setOnClickListener {
            if (!characteristicManager.normalClothes) {
                setSendMessage("In this costume you not let in restaurant")
            }
            else {
                restaurantAction()
            }
        }
    }
}