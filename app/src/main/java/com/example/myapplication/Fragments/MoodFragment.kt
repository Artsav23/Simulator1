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
        setMultiplicationTableAction()
        setCoursesAction()
        setClubAction()
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
                setSendMessage( "Buy normal costume")
            }
        }
    }

    private fun setMultiplicationTableAction() {
        binding.learnMultiplicationTable.setOnClickListener {
            if (characteristicManager.multiplicationTable) {
                setSendMessage( "you know multiplication table")
            }
            else {
                multiplicationTableAction()
            }
        }
    }

    private fun setPasserbyAction() {
        binding.talkWithPasserby.setOnClickListener {
            talkWithPasserby()
        }
    }

    private fun setClubAction() {
        binding.goToTheClub.setOnClickListener {
            if (characteristicManager.clubClothes) {
                goClubAction()
            }
            else {
                setSendMessage( "You should buy Club clothes")
            }
        }
    }

    private fun setCoursesAction() {
        binding.takeCourses.setOnClickListener {
            if (characteristicManager.courseCompletion) {
                setSendMessage("You have already completed the course")
            }
            else {
                if (characteristicManager.money > 75) {
                    takeCoursesAction()
                }
                else {
                    setSendMessage( "Small money")
                }
            }
        }
    }
}