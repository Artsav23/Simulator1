package com.example.myapplication.Main

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import com.example.myapplication.Fragments.*
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class CharacteristicManager() {

    var onReloadListener: () -> Unit = {}
    var food = 30
    var money = 500
    var mood = 30
    var AmountOfFoodEaten = 0
    var spendMoney = 0
    var normalClothes = false
    var clubClothes = false
    var workingClothes = false
    var timeInSimulator = 0


    fun add(food: Int, money: Int, mood: Int) {
        addFood(food)
        addMood(mood)
        this.money += money
        reloadCount()
    }

    fun reloadCount() {
        onReloadListener()
    }

    fun buyClothes (money: Int, context: Context?, kindClothes: Int) {
        if (this.money < money) {
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
        if (this.normalClothes) {
            Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
        }
        else {
            this.normalClothes = true
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            this.money -= money
            this.spendMoney += money
        }
    }

    private fun clubClothes(context: Context?, money: Int) {
        if (this.clubClothes) {
            Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
        }
        else {
            this.clubClothes = true
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            this.money -= money
            this.spendMoney += money
        }
    }

    private fun workingClothes(context: Context?, money: Int) {
        if (this.workingClothes) {
            Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
        }
        else {
            this.workingClothes = true
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            this.money -= money
            this.spendMoney += money
        }
    }

    private fun addFood(food: Int) {
        if (this.food + food > 100){
            this.food = 100
        }
        else if (this.food + food < 0){
            this.food = 0
        }
        else{
            this.food += food
        }
    }

    private fun addMood(mood: Int) {
        if (this.mood + mood > 100){
            this.mood = 100
        }
        else if (this.mood + mood < 0){
            this.mood = 0
        }
        else {
            this.mood += mood
        }
    }

   fun restart() {
        food = 30
        money = 500
        mood = 30
        AmountOfFoodEaten = 0
        spendMoney = 0
        normalClothes = false
        clubClothes = false
        workingClothes = false
        timeInSimulator = 0
       reloadCount()
    }
}