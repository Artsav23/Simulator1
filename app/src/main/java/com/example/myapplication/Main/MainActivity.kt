package com.example.myapplication.Main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.Main.MainActivity.Binding.binding
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel

    object Binding{
    @SuppressLint("StaticFieldLeak")
    lateinit var binding: ActivityMainBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainActivityViewModel = MainActivityViewModel()
        setContentView(binding.root)
        controller()
        mainActivityViewModel.reloadCount()
    }

    private fun controller() {
        val navController = findNavController(R.id.fragment)
        binding.bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, AppBarConfiguration(setOf(R.id.foodFragment,
            R.id.moneyFragment, R.id.moodFragment, R.id.shopFragment)))
    }
}