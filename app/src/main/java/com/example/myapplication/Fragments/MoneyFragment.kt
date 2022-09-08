package com.example.myapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentMoneyBinding

class MoneyFragment : BaseFragment() {

    private lateinit var binding: FragmentMoneyBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMoneyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTrashAction()
        thePanhandleAction()
    }

    private fun setTrashAction() {
        binding.searchInTheTrash.setOnClickListener {
            action(foodRange = -3..2, money =  2..5, mood =  -5..-3, context)
        }
    }

    private fun thePanhandleAction() {
        binding.panhandle.setOnClickListener {
            action(foodRange = -3..1, money = 2..6, mood = -3..-2, context)
        }
    }
}