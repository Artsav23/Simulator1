package com.example.myapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.Main.CharacteristicManager
import com.example.myapplication.databinding.FragmentMoneyBinding

class MoneyFragment(characteristicManager: CharacteristicManager) : BaseFragment(characteristicManager) {

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
            searchTrashAction()
        }
    }

    private fun thePanhandleAction() {
        binding.panhandle.setOnClickListener {
            panhandleAction()
        }
    }
}