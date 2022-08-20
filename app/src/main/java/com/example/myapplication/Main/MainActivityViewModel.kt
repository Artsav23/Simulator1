package com.example.myapplication.Main

import android.content.Context
import android.widget.Toast
import com.example.myapplication.Main.MainActivity.Binding.binding

class MainActivityViewModel {

object Count {
    var food = 30
    var money = 500
    var mood = 30
    var normalClothes = false
    var clubClothes = false
    var workingClothes = false
}

    fun add(food: Int?, money: Int?, mood: Int?) {
        if (food != null) {
            if (Count.food + food > 100){
                Count.food = 100
            }
            else if (Count.food + food < 0){
                Count.food = 0
            }
            else{
                Count.food += food

            }
        }
        if (money != null) {
            Count.money += money
        }
        if (mood !=null) {
            if (Count.mood + mood > 100){
                Count.mood = 100
            }
            else if (Count.mood + mood < 0){
                Count.mood = 0
            }
            else {
                Count.mood += mood
            }
        }
        reloadCount()
    }

    fun reloadCount() {
        binding.foodCounter.text = Count.food.toString()
        binding.moneyCounter.text = Count.money.toString()
        binding.moodCounter.text = Count.mood.toString()
    }

    fun buyClothes (money: Int, context: Context?, kindClothes: Int) {
        if (Count.money < money) {
            Toast.makeText(context, "Small money", Toast.LENGTH_SHORT).show()
        }
        else {
            when (kindClothes) {
                1 -> {
                    if (Count.normalClothes) {
                        Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Count.normalClothes = true
                        Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
                        Count.money -= money
                    }
                }
                2-> {
                    if (Count.clubClothes) {
                        Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Count.clubClothes = true
                        Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
                        Count.money -= money
                    }
                }
                3-> {
                    if (Count.workingClothes) {
                        Toast.makeText(context, "it's already been purchased", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Count.workingClothes = true
                        Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
                        Count.money -= money
                    }
                }
            }
            reloadCount()
        }
    }

}