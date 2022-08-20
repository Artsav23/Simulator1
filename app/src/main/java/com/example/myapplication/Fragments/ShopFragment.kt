package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.Main.MainActivityViewModel
import com.example.myapplication.databinding.FragmentShopBinding

class ShopFragment : Fragment() {

    private lateinit var binding: FragmentShopBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buyNormalCostume.setOnClickListener {
            MainActivityViewModel().buyClothes(50, context, 1)
        }

        binding.buyClubCostume.setOnClickListener {
            MainActivityViewModel().buyClothes(100, context, 2)
        }

        binding.buyWorkingClothes.setOnClickListener {
            MainActivityViewModel().buyClothes(250, context, 3)
        }
    }

}