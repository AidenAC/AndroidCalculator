package com.cis436.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Buttons.KeyboardListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonClick(character: String) {
        val display = supportFragmentManager.findFragmentById(R.id.fragmentDisplay) as DisplayFragment
        display.updateDisplay(character)
    }
}