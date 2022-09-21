package com.example.myapplication.Main

import android.content.Context
import android.widget.Toast

class CharacteristicManager {

    var onReloadListener: () -> Unit = {}
    var food = 30
    var money = 500
    var mood = 30
    var amountOfFoodEaten = 0
    var spendMoney = 0
    var normalClothes = false
    var clubClothes = false
    var workingClothes = false
    var timeInSimulator = 0
    var multiplicationTable = false
    var bullshitDeveloper = false
    var courseCompletion = false


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
            setSendMessage(context, "Small money")
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
            setSendMessage(context, "It's already been purchased")
        }
        else {
            this.normalClothes = true
            setSendMessage(context, "Done")
            this.money -= money
            this.spendMoney += money
        }
    }

    private fun clubClothes(context: Context?, money: Int) {
        if (this.clubClothes) {
            setSendMessage(context, "It's already been purchased")
        }
        else {
            this.clubClothes = true
            setSendMessage(context, "Done")
            this.money -= money
            this.spendMoney += money
        }
    }

    private fun workingClothes(context: Context?, money: Int) {
        if (this.workingClothes) {
            setSendMessage(context, "It's already been purchased")
        }
        else {
            this.workingClothes = true
            setSendMessage(context, "Done")
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


    private fun setSendMessage(context: Context?, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

   fun restart() {
       food = 30
       money = 500
       mood = 30
       amountOfFoodEaten = 0
       spendMoney = 0
       normalClothes = false
       clubClothes = false
       workingClothes = false
       timeInSimulator = 0
       multiplicationTable = false
       bullshitDeveloper = false
       courseCompletion = false
       reloadCount()
    }
}