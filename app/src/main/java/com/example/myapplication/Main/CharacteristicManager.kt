package com.example.myapplication.Main

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import com.example.myapplication.Fragments.*
import com.example.myapplication.Information
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class CharacteristicManager(private var binding: ActivityMainBinding) {
    private var  information = Information


    fun add(food: Int, money: Int, mood: Int) {
        addFood(food)
        addMood(mood)
        Information.money += money
        reloadCount()
    }

    fun reloadCount() {
        binding.foodCounter.text = information.food.toString()
        binding.moneyCounter.text = information.money.toString()
        binding.moodCounter.text = information.mood.toString()
    }

    fun buyClothes (money: Int, context: Context?, kindClothes: Int) {
        if (information.money < money) {
            Toast.makeText(context, "Small money", Toast.LENGTH_SHORT).show()
        }
        else {
            when (kindClothes) {
                1 -> {
                    normalClothes(context, money)
                }
                2-> {
                    clubClothes(context, money)
                }
                3-> {
                   workingClothes(context, money)
                }
            }
            reloadCount()
        }
    }

    private fun normalClothes(context: Context?, money: Int) {
        if (information.normalClothes) {
            Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
        }
        else {
            information.normalClothes = true
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            information.money -= money
            information.spendMoney += money
        }
    }

    private fun clubClothes(context: Context?, money: Int) {
        if (information.clubClothes) {
            Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
        }
        else {
            information.clubClothes = true
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            information.money -= money
            information.spendMoney += money
        }
    }

    private fun workingClothes(context: Context?, money: Int) {
        if (information.workingClothes) {
            Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
        }
        else {
            information.workingClothes = true
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            information.money -= money
            information.spendMoney += money
        }
    }

    private fun addFood(food: Int) {
        if (information.food + food > 100){
            information.food = 100
        }
        else if (Information.food + food < 0){
            information.food = 0
        }
        else{
            information.food += food
        }
    }

    private fun addMood(mood: Int) {
        if (information.mood + mood > 100){
            information.mood = 100
        }
        else if (information.mood + mood < 0){
            information.mood = 0
        }
        else {
            information.mood += mood
        }
    }

   fun restart() {
        information.food = 30
        information.money = 500
        information.mood = 30
        information.AmountOfFoodEaten = 0
        information.spendMoney = 0
        information.normalClothes = false
        information.clubClothes = false
        information.workingClothes = false
        information.timeInSimulator = 0
       reloadCount()
    }

    fun onClickNavBottom(supportFragmentManager: FragmentManager, supportActionBar: ActionBar?, characteristicManager: CharacteristicManager) {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.foodFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.placeHolder, FoodFragment(characteristicManager)).commit()
                    supportActionBar?.title = "Food"
                }

                R.id.moneyFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.placeHolder, MoneyFragment(characteristicManager)).commit()
                    supportActionBar?.title = "Money"
                }

                R.id.moodFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.placeHolder, MoodFragment(characteristicManager)).commit()
                    supportActionBar?.title = "Mood"
                }

                R.id.shopFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.placeHolder, ShopFragment(characteristicManager)).commit()
                    supportActionBar?.title = "Shop"
                }

                R.id.statisticFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.placeHolder, StatisticFragment(characteristicManager)).commit()
                    supportActionBar?.title = "Statistics"
                }
            }
            true
        }
    }
}