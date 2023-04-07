package com.example.myapplication.Fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import com.example.myapplication.InformationAboutSimulatorActivity
import com.example.myapplication.Main.CharacteristicManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentStatisticBinding


class StatisticFragment(private var characteristicManager: CharacteristicManager) : BaseFragment(characteristicManager) {

    lateinit var binding: FragmentStatisticBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentStatisticBinding.inflate(inflater)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        costumeVisibility()
        foodCounter()
        moneyCounter()
        timeCounter()
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
                val builder = AlertDialog.Builder(activity)
                builder.setTitle("Warning")
                    .setMessage("Are you sure? \n All data will be reset.")
                    .setNegativeButton("No"){ _,_ -> }
                    .setPositiveButton("Yes") {
                        _,_ -> characteristicManager.restart()
                        foodCounter()
                        moneyCounter()
                        timeCounter()
                        costumeVisibility()
                    }
                builder.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun costumeVisibility() {
        if (characteristicManager.normalClothes) {
            binding.normalCostume.visibility = View.VISIBLE
        }
        else {
            binding.normalCostume.visibility = View.GONE
        }
        if (characteristicManager.clubClothes) {
            binding.clubCostume.visibility = View.VISIBLE
        }
        else {
            binding.clubCostume.visibility = View.GONE
        }
        if (characteristicManager.workingClothes) {
            binding.workingClothes.visibility = View.VISIBLE
        }
        else {
            binding.workingClothes.visibility = View.GONE
        }

    }


    private fun foodCounter() {
        binding.amountFood.text = characteristicManager.amountOfFoodEaten.toString()
    }

    private fun moneyCounter() {
        binding.spendMoneyNumber.text = characteristicManager.spendMoney.toString()
    }

    @SuppressLint("SetTextI18n")
    private fun timeCounter() {
        binding.time.text = "${characteristicManager.timeInSimulator} min"
    }
}