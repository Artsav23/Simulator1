package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentMoneyBinding

class MoneyFragment : Fragment() {

    private lateinit var binding: FragmentMoneyBinding
    private var foodViewModel = FragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentMoneyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchInTheTrash.setOnClickListener {
            foodViewModel.action(-3..2, 2..3, -5..-3, context)
        }

        binding.panhandle.setOnClickListener {
                foodViewModel.action(-3..1, 1..6, -3..-2, context)
        }
    }
}