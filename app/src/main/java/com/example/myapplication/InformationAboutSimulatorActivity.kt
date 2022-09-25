package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.myapplication.databinding.ActivityInformationAboutSimulatorBinding

class InformationAboutSimulatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformationAboutSimulatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationAboutSimulatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Description"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.description.text = getText(R.string.description)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}