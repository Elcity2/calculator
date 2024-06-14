package com.lemien.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var numberInput: EditText
    private lateinit var add: Button
    private lateinit var sub: Button
    private lateinit var div: Button
    private lateinit var multiply: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        numberInput = findViewById(R.id.num)
        add = findViewById(R.id.add)
        sub = findViewById(R.id.subtract)
        multiply = findViewById(R.id.multiply)
        div = findViewById(R.id.divide)

        add.setOnClickListener { performOperation(Operation.ADD) }
        sub.setOnClickListener { performOperation(Operation.SUBTRACT) }
        div.setOnClickListener { performOperation(Operation.DIVIDE) }
        multiply.setOnClickListener { performOperation(Operation.MULTIPLY) }
    }
    private fun performOperation(operation: Operation) {
        val inputText = numberInput.text.toString()

        if (inputText.isBlank()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
            return
        }

        val number = inputText.toDouble()

        val result = when (operation) {
            Operation.ADD -> number + 2
            Operation.SUBTRACT -> number - 2
            Operation.DIVIDE -> number / 2
            Operation.MULTIPLY -> number * 2
        }

        numberInput.setText(result.toString())
    }

    private enum class Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY
    }
}

        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        */
