package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.Main.CharacteristicManager
import com.example.myapplication.databinding.FragmentShopBinding

class ShopFragment(private var viewModel: CharacteristicManager) : BaseFragment(characteristicManager = viewModel) {

    private lateinit var binding: FragmentShopBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentShopBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        normalCostumeAction()
        clubCostumeAction()
        workingClothesAction()
        bullshitImposedByTheDeveloperAction()
    }

    private fun normalCostumeAction() {
        binding.buyNormalCostume.setOnClickListener {
            viewModel.buyClothes(money = 50, context, kindClothes =  1)
        }
    }

    private fun clubCostumeAction() {
        binding.buyClubCostume.setOnClickListener {
            viewModel.buyClothes(money = 100, context, kindClothes = 2)
        }
    }

    private fun workingClothesAction() {
        binding.buyWorkingClothes.setOnClickListener {
            viewModel.buyClothes(money = 250, context, kindClothes = 3)
        }
    }

    private fun bullshitImposedByTheDeveloperAction() {
        binding.buyBullshitImposedByTheDeveloper.setOnClickListener {
            bullshitAction()
        }
    }
}