package com.example.myapplication.Fragments

import android.content.Context
import android.widget.Toast
import com.example.myapplication.Main.CharacteristicManager

class FragmentManager {

    var count = CharacteristicManager.Information

    fun action (foodRange: IntRange, money: IntRange, mood: IntRange, context: Context?) {
        val foodPoint = foodRange.random()
        val moodPoint = mood.random()
        val moneyPoint = money.random()
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint, context)
    }

    private fun checkFood(foodPoint: Int, moodPoint: Int, moneyPoint: Int, context: Context?) {
        if (count.food + foodPoint < 0 ) {
            Toast.makeText(context, "You are hungry", Toast.LENGTH_SHORT).show()
        }
        else {
            checkMood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint, context)
        }
    }

    private fun checkMood(foodPoint: Int, moodPoint: Int, moneyPoint: Int, context: Context?) {
        if (count.mood + moodPoint < 0) {
            Toast.makeText(context, "You are not funny", Toast.LENGTH_SHORT).show()
        }
        else {
            checkMoney(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint, context)
        }
    }

    private fun checkMoney(foodPoint: Int, moodPoint: Int, moneyPoint: Int, context: Context?) {
        if (count.money + moneyPoint < 0) {
            Toast.makeText(context, "Small money", Toast.LENGTH_SHORT).show()
        }
        else {
            if (moneyPoint < 0){
                count.spendMoney -= moneyPoint
            }
            if (foodPoint > 0 ) {
                count.AmountOfFoodEaten += 1
            }
            CharacteristicManager().add(food = foodPoint, money = moneyPoint, mood = moodPoint)
        }
    }

}