package com.example.myapplication.Fragments

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.Main.CharacteristicManager

open class BaseFragment(private var characteristicManager: CharacteristicManager): Fragment() {


    private fun checkFood(foodPoint: Int, moodPoint: Int, moneyPoint: Int) {
        if (characteristicManager.food + foodPoint < 0 ) {
            setSendMessage("You are hungry")
        }
        else {

            checkMood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
        }
    }

    private fun checkMood(foodPoint: Int, moodPoint: Int, moneyPoint: Int) {
        if (characteristicManager.mood + moodPoint < 0) {
            setSendMessage("You are not funny")
        }
        else {
            checkMoney(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
        }
    }

    private fun checkMoney(foodPoint: Int, moodPoint: Int, moneyPoint: Int) {
        if (characteristicManager.money + moneyPoint < 0) {
            setSendMessage( "Small money")
        }
        else {
            if (moneyPoint < 0){
                characteristicManager.spendMoney -= moneyPoint
            }
            if (foodPoint > 0 ) {
                characteristicManager.amountOfFoodEaten += 1
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

    fun restaurantAction() {
        val foodPoint = (15..20).random()
        val moodPoint = 5
        val moneyPoint = -50
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun hotDogAction() {
        val foodPoint = (4..6).random()
        val moodPoint = 0
        val moneyPoint = -5
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun multiplicationTableAction() {
        if (characteristicManager.money < 10){
            setSendMessage( "Small money")
        }
        else{
            characteristicManager.multiplicationTable = true
            characteristicManager.add(food = -2, mood = 10, money = -10)
        }

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
    fun goClubAction() {
        val foodPoint = (-5..-3).random()
        val moodPoint = (15..30).random()
        val moneyPoint = -25
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun panhandleAction() {
        val foodPoint = (-3..1).random()
        val moodPoint = (-3..-2).random()
        val moneyPoint = (2..6).random()
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun workShopAction() {
        val moodPoint = (-10..-7).random()
        val foodPoint = (-10..-7).random()
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = 25)
    }
    fun workOfficeAction() {
        val moodPoint = (-13..-10).random()
        val foodPoint = (-13..-10).random()
        checkFood(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = 100)
    }

    fun bullshitAction() {
        if (characteristicManager.bullshitDeveloper) {
            setSendMessage( "Why do you need a second such crap?")
        }
        else {
            characteristicManager.bullshitDeveloper = true
            setSendMessage( "Congratulation! You buy don't know what")
        }
    }

    fun takeCoursesAction() {
        characteristicManager.courseCompletion = true
        checkMoney(foodPoint = 0, moodPoint = 20, moneyPoint = -75)
    }

    protected fun setSendMessage( message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}