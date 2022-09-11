package com.example.myapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.Main.CharacteristicManager
import com.example.myapplication.databinding.FragmentMoodBinding

class MoodFragment(private var characteristicManager: CharacteristicManager) : BaseFragment(characteristicManager) {

    private lateinit var binding: FragmentMoodBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMoodBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        walkToParkAction()
        iceSkatingAction()
        setPasserbyAction()
    }

    private fun walkToParkAction() {
        binding.walkToPark.setOnClickListener {
            parkAction()
        }
    }

    private fun iceSkatingAction() {
        binding.goToIceSkating.setOnClickListener {
            if (characteristicManager.normalClothes) {
                goIceSkatingAction()
            }
            else {
                Toast.makeText(context, "Buy normal costume", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setPasserbyAction() {
        binding.talkWithPasserby.setOnClickListener {
            talkWithPasserby()
        }
    }
}