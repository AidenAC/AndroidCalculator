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

        //Numbers Buttons
        binding.btZero.setOnClickListener {
            buttonPressed("0")
        }
        binding.btOne.setOnClickListener {
            buttonPressed("1")
        }
        binding.btTwo.setOnClickListener {
            buttonPressed("2")
        }
        binding.btThree.setOnClickListener {
            buttonPressed("3")
        }
        binding.btFour.setOnClickListener {
            buttonPressed("4")
        }
        binding.btFive.setOnClickListener {
            buttonPressed("5")
        }
        binding.btSix.setOnClickListener {
            buttonPressed("6")
        }
        binding.btSeven.setOnClickListener {
            buttonPressed("7")
        }
        binding.btEight.setOnClickListener {
            buttonPressed("8")
        }
        binding.btNine.setOnClickListener {
            buttonPressed("9")
        }
        binding.btDecimal.setOnClickListener {
            buttonPressed(".")
        }
        binding.btInverse.setOnClickListener {
            buttonPressed("!")
        }

        //Arithmetic Buttons
        binding.btAdd.setOnClickListener {
            buttonPressed("+")
        }
        binding.btSubtract.setOnClickListener {
            buttonPressed("-")
        }
        binding.btMultiply.setOnClickListener {
            buttonPressed("*")
        }
        binding.btDivide.setOnClickListener {
            buttonPressed("/")
        }
        binding.btModulus.setOnClickListener {
            buttonPressed("%")
        }
        binding.btSquareRoot.setOnClickListener {
            buttonPressed("SQRT")
        }
        binding.btEquals.setOnClickListener {
            buttonPressed("=")
        }

        return binding.root
    }

    private fun buttonPressed(character: String) {
        activityCallback.onButtonClick(character)
    }
}