package com.cis436.project2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cis436.project2.databinding.FragmentDisplayBinding
import java.util.LinkedList
import java.util.Queue

class DisplayFragment : Fragment() {
    private lateinit var binding: FragmentDisplayBinding

    private var calculate : Queue<String> = LinkedList()

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
            "+" -> setCalculation(currentNum, character)
            "-" -> setCalculation(currentNum, character)
            "*" -> setCalculation(currentNum, character)
            "/" -> setCalculation(currentNum, character)
            "!" -> inverse(currentNum)
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

    private fun inverse(number: String) {
        if (number.toDouble() != 0.0) {
            val inverseNum = if (number.startsWith("-")) {
                number.replace("-", "")
            } else {
                "-" + number
            }
            binding.tvDisplay.text = inverseNum
        }
    }

    private fun setCalculation(number : String, operation : String) {
        calculate.add(number)
        calculate.add(operation)

        //Debug: print queue to console
        for (item in calculate) Log.d("MyTag", item)

        binding.tvDisplay.text = "0"
    }
}