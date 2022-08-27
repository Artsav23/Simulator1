package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.Main.CharacteristicManager
import com.example.myapplication.databinding.FragmentStatisticBinding


class StatisticFragment : Fragment() {

    lateinit var  binding: FragmentStatisticBinding
    private var costume = CharacteristicManager.Information

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentStatisticBinding.inflate(inflater)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        costume()
        amountFood()
        spendMoney()
        time()
    }

    private fun costume() {
        if (costume.normalClothes) {
            binding.normalCostume.visibility = View.VISIBLE
        }
        if (costume.clubClothes) {
            binding.clubCostume.visibility = View.VISIBLE
        }
        if (costume.workingClothes) {
            binding.workingClothes.visibility = View.VISIBLE
        }
    }

    private fun amountFood() {
        binding.amountFood.text = CharacteristicManager.Information.AmountOfFoodEaten.toString()
    }

    private fun spendMoney() {
        binding.spendMoneyNumber.text = CharacteristicManager.Information.spendMoney.toString()
    }

    private fun time() {
        binding.time.text = "${CharacteristicManager.Information.timeInSimulator} min"
    }
}