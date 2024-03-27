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

    private var newNum = true

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
                if (currentNum == "0" || newNum) {
                    binding.tvDisplay.text = character
                } else {
                    binding.tvDisplay.text = binding.tvDisplay.text.toString() + character
                }
                newNum = false
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

        if (calculate.size == 3) {
            val number1 = calculate.remove()
            val arithmetic = calculate.remove()
            val number2 = calculate.remove()

            val result = when (arithmetic) {
                "+" -> add(number1.toDouble(), number2.toDouble())
                "-" -> subtract(number1.toDouble(), number2.toDouble())
                "*" -> multiply(number1.toDouble(), number2.toDouble())
                "/" -> divide(number1.toDouble(), number2.toDouble())
                else -> 0.0
            }

            calculate.add(result.toString())
            binding.tvDisplay.text = result.toString()
        }

        calculate.add(operation)

        //Debug: print queue to console
        for (item in calculate) Log.d("MyTag", item)

        newNum = true
    }

    //Arithmetic Operations
    private fun add(number1 : Double, number2 : Double) = number1 + number2
    private fun subtract(number1 : Double, number2 : Double) = number1 - number2
    private fun multiply(number1 : Double, number2 : Double) = number1 * number2
    private fun divide(number1 : Double, number2 : Double) = number1 / number2
}