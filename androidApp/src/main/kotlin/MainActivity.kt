/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package sample.calculator.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import sample.calculator.arithmeticparser.Fibonacci
import sample.calculator.arithmeticparser.parseAndCompute


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultView = findViewById<TextView>(R.id.computed_result)
        val input = findViewById<EditText>(R.id.input)

        parseExpression.setOnClickListener {
            val inputText = input.text.toString()
            val result = parseAndCompute(inputText).expression
            if (result != null)
                resultView.text = result.toString()
            else
                resultView.text = "Unable to parse $inputText"
        }

        getFibonacci.setOnClickListener {
            val number = input.text.toString()
            val fibonacciOutput = Fibonacci(number).findFibonacciSum()
            if (fibonacciOutput < 0)
                resultView.text = getString(R.string.only_number)
            else
                resultView.text = fibonacciOutput.toString()


        }
    }
}

