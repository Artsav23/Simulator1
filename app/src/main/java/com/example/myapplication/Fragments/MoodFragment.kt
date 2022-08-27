package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.Main.CharacteristicManager
import com.example.myapplication.databinding.FragmentMoodBinding

class MoodFragment : Fragment() {

    private lateinit var binding: FragmentMoodBinding
    private var moodManager = FragmentManager()
    var count = CharacteristicManager.Information

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMoodBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        walkToPark()
        goToIceSkating()
        talkWithPasserby()
    }

    private fun walkToPark() {
        binding.walkToPark.setOnClickListener {
            moodManager.action(-2..0, 0..0, 3..6, context)
        }
    }

    private fun goToIceSkating() {
        binding.goToIceSkating.setOnClickListener {
            if (count.normalClothes) {
                moodManager.action(-10..-3, -10..-10, 10..15, context)
            }
            else {
                Toast.makeText(context, "Buy normal costume", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun talkWithPasserby() {
        binding.talkWithPasserby.setOnClickListener {
            moodManager.action(-2..0, 0..2, 3..6, context)
        }
    }
}