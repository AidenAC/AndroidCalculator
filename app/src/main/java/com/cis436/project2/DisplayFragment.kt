package com.cis436.project2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cis436.project2.databinding.FragmentDisplayBinding

class DisplayFragment : Fragment() {
    private lateinit var binding: FragmentDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDisplayBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun updateDisplay(character : String) {
        var currentNum = binding.tvDisplay.text.toString()
        when (character) {
            "!" -> {
                if (currentNum.toDouble() != 0.0) {
                    currentNum = if (currentNum.startsWith("-")) {
                        currentNum.replace("-", "")
                    } else {
                        "-" + currentNum
                    }
                    binding.tvDisplay.text = currentNum
                }
            }
            "." -> {
                currentNum = currentNum.replace(character, "")
                binding.tvDisplay.text = currentNum + character
            }
            else -> {
                if (currentNum.toDouble() == 0.0) {
                    binding.tvDisplay.text = character
                } else {
                    binding.tvDisplay.text = binding.tvDisplay.text.toString() + character
                }
            }
        }
    }
}