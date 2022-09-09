package com.example.myapplication.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Fragments.*
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var characteristicManager: CharacteristicManager
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        characteristicManager = CharacteristicManager(binding)
        setContentView(binding.root)
        characteristicManager.reloadCount()
        supportFragmentManager.beginTransaction().replace(R.id.placeHolder, FoodFragment(characteristicManager)).commit()
        characteristicManager.onClickNavBottom(supportActionBar = supportActionBar,
            supportFragmentManager = supportFragmentManager, characteristicManager = characteristicManager)
    }
}
