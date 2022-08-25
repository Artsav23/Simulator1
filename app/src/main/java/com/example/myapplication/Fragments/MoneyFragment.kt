package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentMoneyBinding

class MoneyFragment : Fragment() {

    private lateinit var binding: FragmentMoneyBinding
    private var moneyManager = FragmentManager()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMoneyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchInTheTrash()
        panhandle()
    }

    private fun searchInTheTrash() {
        binding.searchInTheTrash.setOnClickListener {
            moneyManager.action(foodRange = -3..2, money =  2..3, mood =  -5..-3, context)
        }
    }

    private fun panhandle() {
        binding.panhandle.setOnClickListener {
            moneyManager.action(foodRange = -3..1, money = 1..6, mood = -3..-2, context)
        }
    }
}