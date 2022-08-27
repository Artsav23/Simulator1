package com.example.myapplication.Main

import android.content.Context
import android.widget.Toast
import com.example.myapplication.Main.MainActivity.Binding.binding

class CharacteristicManager {

object Information {
    var food = 30
    var money = 500
    var mood = 30
    var AmountOfFoodEaten = 0
    var spendMoney = 0
    var normalClothes = false
    var clubClothes = false
    var workingClothes = false
    var timeInSimulator = 0
}

    fun add(food: Int, money: Int, mood: Int) {
        addFood(food)
        addMood(mood)
        Information.money += money
        reloadCount()
    }

    fun reloadCount() {
        binding.foodCounter.text = Information.food.toString()
        binding.moneyCounter.text = Information.money.toString()
        binding.moodCounter.text = Information.mood.toString()
    }

    fun buyClothes (money: Int, context: Context?, kindClothes: Int) {
        if (Information.money < money) {
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
        if (Information.normalClothes) {
            Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
        }
        else {
            Information.normalClothes = true
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            Information.money -= money
            Information.spendMoney += money
        }
    }

    private fun clubClothes(context: Context?, money: Int) {
        if (Information.clubClothes) {
            Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
        }
        else {
            Information.clubClothes = true
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            Information.money -= money
            Information.spendMoney += money
        }
    }

    private fun workingClothes(context: Context?, money: Int) {
        if (Information.workingClothes) {
            Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
        }
        else {
            Information.workingClothes = true
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            Information.money -= money
            Information.spendMoney += money
        }
    }

    private fun addFood(food: Int) {
        if (Information.food + food > 100){
            Information.food = 100
        }
        else if (Information.food + food < 0){
            Information.food = 0
        }
        else{
            Information.food += food
        }
    }

    private fun addMood(mood: Int) {
        if (Information.mood + mood > 100){
            Information.mood = 100
        }
        else if (Information.mood + mood < 0){
            Information.mood = 0
        }
        else {
            Information.mood += mood
        }
    }
}