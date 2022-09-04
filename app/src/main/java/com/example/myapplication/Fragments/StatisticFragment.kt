package com.example.myapplication.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.myapplication.Information
import com.example.myapplication.InformationAboutSimulatorActivity
import com.example.myapplication.Main.CharacteristicManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentStatisticBinding


class StatisticFragment : FragmentManager() {

    lateinit var  binding: FragmentStatisticBinding
    private var costume = Information
    private var characteristicManager = CharacteristicManager()

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
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_statistic, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.info -> startActivity(Intent(activity, InformationAboutSimulatorActivity::class.java))
            R.id.restart -> {
                characteristicManager.restart()
                amountFood()
                spendMoney()
                time()
                costume()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun costume() {
        if (costume.normalClothes) {
            binding.normalCostume.visibility = View.VISIBLE
        }
        else {
            binding.normalCostume.visibility = View.GONE
        }
        if (costume.clubClothes) {
            binding.clubCostume.visibility = View.VISIBLE
        }
        else {
            binding.clubCostume.visibility = View.GONE
        }
        if (costume.workingClothes) {
            binding.workingClothes.visibility = View.VISIBLE
        }
        else {
            binding.workingClothes.visibility = View.GONE
        }

    }


    private fun amountFood() {
        binding.amountFood.text = Information.AmountOfFoodEaten.toString()
    }

    private fun spendMoney() {
        binding.spendMoneyNumber.text = Information.spendMoney.toString()
    }

    private fun time() {
        binding.time.text = "${Information.timeInSimulator} min"
    }
}