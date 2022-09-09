package com.example.myapplication.Fragments

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.Information
import com.example.myapplication.Main.CharacteristicManager

open class BaseFragment(private var characteristicManager: CharacteristicManager): Fragment() {

    open var information = Information


    private fun checkFood(foodPoint: Int, moodPoint: Int, moneyPoint: Int) {
        if (information.food + foodPoint < 0 ) {
            Toast.makeText(context, "You are hungry", Toast.LENGTH_SHORT).show()
        }
        else {
            checkMood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
        }
    }

    private fun checkMood(foodPoint: Int, moodPoint: Int, moneyPoint: Int) {
        if (information.mood + moodPoint < 0) {
            Toast.makeText(context, "You are not funny", Toast.LENGTH_SHORT).show()
        }
        else {
            checkMoney(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
        }
    }

    private fun checkMoney(foodPoint: Int, moodPoint: Int, moneyPoint: Int) {
        if (information.money + moneyPoint < 0) {
            Toast.makeText(context, "Small money", Toast.LENGTH_SHORT).show()
        }
        else {
            if (moneyPoint < 0){
                information.spendMoney -= moneyPoint
            }
            if (foodPoint > 0 ) {
                information.AmountOfFoodEaten += 1
            }
            characteristicManager.add(food = foodPoint, money = moneyPoint, mood = moodPoint)
        }
    }

    fun garbageAction() {
        val foodPoint = (1..3).random()
        val moodPoint = (-3..-1).random()
        val moneyPoint = 0
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun pizzaAction() {
        val foodPoint = (6..10).random()
        val moodPoint = 0
        val moneyPoint = -10
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun cafeAction() {
        val foodPoint = (10..15).random()
        val moodPoint = 0
        val moneyPoint = -25
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun hotDogAction() {
        val foodPoint = (4..6).random()
        val moodPoint = 0
        val moneyPoint = -5
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun searchTrashAction() {
        val foodPoint = (-3..2).random()
        val moodPoint = (-5..-3).random()
        val moneyPoint = (2..5).random()
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }
     fun parkAction() {
        val foodPoint = (-2..0).random()
        val moodPoint = (3..6).random()
        val moneyPoint = 0
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun talkWithPasserby() {
        val foodPoint = (-2..0).random()
        val moodPoint = (3..10).random()
        val moneyPoint = (0..2).random()
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun goIceSkatingAction() {
        val foodPoint = (-10..-3).random()
        val moodPoint = (10..15).random()
        val moneyPoint = -10
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun panhandleAction() {
        val foodPoint = (-3..1).random()
        val moodPoint = (-3..-2).random()
        val moneyPoint = (2..6).random()
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }
}