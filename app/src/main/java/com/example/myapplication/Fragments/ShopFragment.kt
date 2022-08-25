package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.Main.CharacteristicManager
import com.example.myapplication.databinding.FragmentShopBinding

class ShopFragment : Fragment() {

    private lateinit var binding: FragmentShopBinding
    private var viewModel = CharacteristicManager()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentShopBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buyNormalCostume()
        buyClubCostume()
        buyWorkingClothes()
    }

    private fun buyNormalCostume() {
        binding.buyNormalCostume.setOnClickListener {
            viewModel.buyClothes(money = 50, context, kindClothes =  1)
        }
    }

    private fun buyClubCostume() {
        binding.buyClubCostume.setOnClickListener {
            viewModel.buyClothes(money = 100, context, kindClothes = 2)
        }
    }

    private fun buyWorkingClothes() {
        binding.buyWorkingClothes.setOnClickListener {
            viewModel.buyClothes(money = 250, context, kindClothes = 3)
        }
    }
}