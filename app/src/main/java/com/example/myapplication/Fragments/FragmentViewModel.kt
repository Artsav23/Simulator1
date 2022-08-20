package com.example.myapplication.Fragments

import android.content.Context
import android.widget.Toast
import com.example.myapplication.Main.MainActivityViewModel

class FragmentViewModel {


    fun action (foodRange: IntRange?, money: IntRange?, mood: IntRange?, context: Context?) {
        val foodPoint = foodRange?.random()
        val moodPoint = mood?.random()
        val moneyPoint = money?.random()
        if (MainActivityViewModel.Count.food + foodPoint!! < 0 ) {
            Toast.makeText(context, "You are hungry", Toast.LENGTH_SHORT).show()
        }
        else {

            if (MainActivityViewModel.Count.mood + moodPoint!! < 0) {
                Toast.makeText(context, "You are not funny", Toast.LENGTH_SHORT).show()
            }
            else {
                if (MainActivityViewModel.Count.money + moneyPoint!! < 0) {
                    Toast.makeText(context, "Small money", Toast.LENGTH_SHORT).show()
                }
                else {
                    MainActivityViewModel().add(foodPoint, moneyPoint, moodPoint)
                }
            }
        }
    }

    fun checkMoney (foodRange: IntRange, money: Int, moodRange: IntRange?, context: Context?) {
        if (MainActivityViewModel.Count.money < money) {
            Toast.makeText(context, "Small money", Toast.LENGTH_SHORT).show()
        }
        else {
            action(foodRange, -money..-money, moodRange, context)
        }
    }
}