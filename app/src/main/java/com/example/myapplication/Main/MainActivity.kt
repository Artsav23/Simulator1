package com.example.myapplication.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import com.example.myapplication.Fragments.*
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private var characteristicManager = CharacteristicManager()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        characteristicManager.onReloadListener = {
            binding.foodCounter.text = characteristicManager.food.toString()
            binding.moneyCounter.text = characteristicManager.money.toString()
            binding.moodCounter.text = characteristicManager.mood.toString()
        }
        setContentView(binding.root)

        characteristicManager.reloadCount()
        thread {
            minuteInSimulator()
        }
        supportFragmentManager.beginTransaction().replace(R.id.placeHolder, FoodFragment(characteristicManager)).commit()
        onClickNavBottom()
    }

     private fun minuteInSimulator() {
         while (true) {
             Thread.sleep(60000)
             characteristicManager.timeInSimulator += 1
         }
    }

    private fun onClickNavBottom() {
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
