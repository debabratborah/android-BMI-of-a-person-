package com.example.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.tictactoe.R.layout.activity_main)

        val edWeight = findViewById<EditText>(R.id.wt)
        val edHeightFt = findViewById<EditText>(R.id.htFt)
        val edHeightIn = findViewById<EditText>(R.id.htIn)
        val txtResult = findViewById<TextView>(R.id.result)
        val btCalBmi = findViewById<Button>(R.id.Cal_btn)
        val llmain = findViewById<LinearLayout>(R.id.LLmain)

        btCalBmi.setOnClickListener {
            val wt = edWeight.text.toString().toIntOrNull()
            val hFt = edHeightFt.text.toString().toIntOrNull()
            val hIn = edHeightIn.text.toString().toIntOrNull()

            if (wt != null && hFt != null && hIn != null) {
                val totalIn = (hFt * 12 + hIn)
                val totalHtInm = (totalIn * 0.0254)
                val bmi = wt / (totalHtInm * totalHtInm)
                when {
                    bmi > 25 -> {
                        txtResult.setText(R.string.overweight)
                        llmain.setBackgroundColor(resources.getColor(R.color.colourOw, null))
                    }
                    bmi < 18 -> {
                        txtResult.setText(R.string.underweight)
                        llmain.setBackgroundColor(resources.getColor(R.color.colourUw, null))
                    }
                    else -> {
                        txtResult.setText(R.string.healthy)
                        llmain.setBackgroundColor(resources.getColor(R.color.colourHlthy, null))
                    }
                }
            } else {
                txtResult.text = "Please enter valid numbers"
            }
        }
    }
}


