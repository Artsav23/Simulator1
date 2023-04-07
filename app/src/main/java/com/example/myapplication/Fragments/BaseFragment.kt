package com.example.myapplication.Fragments

import android.app.AlertDialog
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.Main.CharacteristicManager

open class BaseFragment(private var characteristicManager: CharacteristicManager): Fragment() {

    private fun checkResources(foodPoint: Int, moodPoint: Int, moneyPoint: Int) {
        if (characteristicManager.food + foodPoint < 0 || characteristicManager.mood + moodPoint < 0||
            characteristicManager.money + moneyPoint < 0) {
            checkFood(foodPoint)
            checkMoney(moneyPoint)
            checkMood(moodPoint)
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

    private fun checkFood(foodPoint: Int) {
        if (characteristicManager.food + foodPoint < 0 ) {
            setSendMessage("You are hungry")
        }
    }

    private fun checkMood(moodPoint: Int) {
        if (characteristicManager.mood + moodPoint < 0) {
            setSendMessage("You are not funny")
        }
    }

    private fun checkMoney(moneyPoint: Int) {
        if (characteristicManager.money + moneyPoint < 0) {
            setSendMessage( "Small money")
        }
    }

    fun garbageAction() {
        val foodPoint = (1..3).random()
        val moodPoint = (-3..-1).random()
        val moneyPoint = 0
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun pizzaAction() {
        val foodPoint = (6..10).random()
        val moodPoint = 0
        val moneyPoint = -10
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun cafeAction() {
        val foodPoint = (10..15).random()
        val moodPoint = 0
        val moneyPoint = -25
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun restaurantAction() {
        val foodPoint = (15..20).random()
        val moodPoint = 5
        val moneyPoint = -50
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun hotDogAction() {
        val foodPoint = (4..6).random()
        val moodPoint = 0
        val moneyPoint = -5
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
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
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }
     fun parkAction() {
        val foodPoint = (-2..0).random()
        val moodPoint = (3..6).random()
        val moneyPoint = 0
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun talkWithPasserby() {
        val foodPoint = (-2..0).random()
        val moodPoint = (3..10).random()
        val moneyPoint = (0..2).random()
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun goIceSkatingAction() {
        val foodPoint = (-10..-3).random()
        val moodPoint = (10..15).random()
        val moneyPoint = -10
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }
    fun goClubAction() {
        val foodPoint = (-5..-3).random()
        val moodPoint = (15..30).random()
        val moneyPoint = -25
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun panhandleAction() {
        val foodPoint = (-3..1).random()
        val moodPoint = (-3..-2).random()
        val moneyPoint = (2..6).random()
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = moneyPoint)
    }

    fun workShopAction() {
        val moodPoint = (-10..-7).random()
        val foodPoint = (-10..-7).random()
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = 25)
    }
    fun workOfficeAction() {
        val moodPoint = (-13..-10).random()
        val foodPoint = (-13..-10).random()
        checkResources(foodPoint = foodPoint, moodPoint = moodPoint, moneyPoint = 100)
    }

    fun bullshitAction() {
        if (characteristicManager.bullshitDeveloper) {
            setSendMessage( "Why do you need a second such crap?")
        }
        else {
            if (characteristicManager.money >= 999) {
                val builder = AlertDialog.Builder(activity)
                builder.setMessage("Congratulation! You buy don't know what, game over \n Restart?")
                    .setNegativeButton("No") { _, _ -> }
                    .setPositiveButton("Yes") { _, _ ->
                        characteristicManager.restart()
                    }
                    .show()
                characteristicManager.bullshitDeveloper = true
                characteristicManager.money -= 999
                characteristicManager.reloadCount()
            }
            else {
                setSendMessage("No money maaan.")
            }
        }
    }

    fun takeCoursesAction() {
        characteristicManager.courseCompletion = true
        checkResources(foodPoint = 0, moodPoint = 20, moneyPoint = -75)
    }

    protected fun setSendMessage( message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}