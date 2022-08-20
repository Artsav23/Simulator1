package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.Main.MainActivityViewModel
import com.example.myapplication.databinding.FragmentMoodBinding

class MoodFragment : Fragment() {

    private lateinit var binding: FragmentMoodBinding
    private var fragmentViewModel = FragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentMoodBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.walkToPark.setOnClickListener {
            fragmentViewModel.action(-2..0, 0..0, 3..6, context)
        }

        binding.talkWithPasserby.setOnClickListener {
            fragmentViewModel.action(-2..0, 0..2, 3..6, context)
        }

        binding.goToIceSkating.setOnClickListener {
            if (MainActivityViewModel.Count.normalClothes) {
                fragmentViewModel.action(-10..-3, -10..-10, 10..15, context)
            }
            else {
                Toast.makeText(context, "Buy normal costume", Toast.LENGTH_SHORT).show()
            }
        }
    }
}