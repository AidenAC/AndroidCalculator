package com.cis436.project2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cis436.project2.databinding.FragmentButtonsBinding

class Buttons : Fragment() {
    private lateinit var activityCallback : Buttons.KeyboardListener
    private lateinit var binding : FragmentButtonsBinding
    interface KeyboardListener {
        fun onButtonClick(character : String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as KeyboardListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + " must implement KeyboardListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentButtonsBinding.inflate(inflater, container, false)

        binding.btZero.setOnClickListener {
            buttonPressed("0")
        }

        return binding.root
    }

    private fun buttonPressed(character: String) {
        activityCallback.onButtonClick(character)
    }
}