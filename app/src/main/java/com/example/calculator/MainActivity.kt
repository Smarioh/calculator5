package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.*
import kotlin.text.toInt

class MainActivity : AppCompatActivity() {
    private lateinit var calculateButton: Button

    private lateinit var num1: EditText
    private lateinit var num2: EditText

    private lateinit var result: TextView

    private lateinit var add: Button
    private lateinit var sub: Button
    private lateinit var mul: Button
    private lateinit var div: Button

    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButton = findViewById(R.id.calculateButton)
        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        result = findViewById(R.id.result)

        add = findViewById(R.id.add)
        sub = findViewById(R.id.sub)
        mul = findViewById(R.id.mul)
        div = findViewById(R.id.div)

        // Add filters to input to disallow more than one '.' and '-'
        num1.filters = arrayOf(InputFilter{source, _, _, _, _, _ ->
            val newText = num1.text.toString() + source.toString()
            if (newText.count {it == '.'} > 1) {
                ""
            }
            else if (newText.length > 1 && source.toString() == "-") {
                ""
            }
            else{
                null
            }
        })
        num2.filters = arrayOf(InputFilter{source, _, _, _, _, _ ->
            val newText = num2.text.toString() + source.toString()
            if (newText.count {it == '.'} > 1) {
                ""
            }
            else if (newText.length > 1 && source.toString() == "-") {
                ""
            }
            else{
                null
            }
        })

        // Wire up each button to set calculator operation
        add.setOnClickListener { view: View ->
            operator = "add"
        }
        sub.setOnClickListener { view: View ->
            operator = "sub"
        }
        mul.setOnClickListener { view: View ->
            operator = "mul"
        }
        div.setOnClickListener { view: View ->
            operator = "div"
        }

        // Wire up calculate button
        calculateButton.setOnClickListener { view: View ->
            if(operator == "div" && num2.text.toString().toInt() == 0){
                Toast.makeText(this, "Divide by 0 not allowed", Toast.LENGTH_LONG).show()
            }
            else if(operator == "add"){
                var n1 = 0.0
                var n2 = 0.0

                if(num1.text.toString().startsWith("-")){
                    n1 = num1.text.toString().substring(1).toDouble() * -1
                }
                else{
                    n1 = num1.text.toString().toDouble()
                }
                if(num2.text.toString().startsWith("-")){
                    n2 = num2.text.toString().substring(1).toDouble() * -1
                }
                else{
                    n2 = num2.text.toString().toDouble()
                }

                var answer =
                    (n1 + n2 + 0.0)
                if(answer > Double.MAX_VALUE){
                    Toast.makeText(this, "Number not computable, too large", Toast.LENGTH_LONG).show()
                }
                else{
                    result.setText(answer.toString())
                }

            }
            else if(operator == "sub"){
                var n1 = 0.0
                var n2 = 0.0

                if(num1.text.toString().startsWith("-")){
                    n1 = num1.text.toString().substring(1).toDouble() * -1
                }
                else{
                    n1 = num1.text.toString().toDouble()
                }
                if(num2.text.toString().startsWith("-")){
                    n2 = num2.text.toString().substring(1).toDouble() * -1
                }
                else{
                    n2 = num2.text.toString().toDouble()
                }

                var answer =
                    (n1 - n2 - 0.0)
                if(answer > Double.MAX_VALUE){
                    Toast.makeText(this, "Number not computable, too large", Toast.LENGTH_LONG).show()
                }
                else{
                    result.setText(answer.toString())
                }

            }
            else if(operator == "mul"){
                var n1 = 0.0
                var n2 = 0.0

                if(num1.text.toString().startsWith("-")){
                    n1 = num1.text.toString().substring(1).toDouble() * -1
                }
                else{
                    n1 = num1.text.toString().toDouble()
                }
                if(num2.text.toString().startsWith("-")){
                    n2 = num2.text.toString().substring(1).toDouble() * -1
                }
                else{
                    n2 = num2.text.toString().toDouble()
                }

                var answer =
                    (n1 * n2 + 0.0)
                if(answer > Double.MAX_VALUE){
                    Toast.makeText(this, "Number not computable, too large", Toast.LENGTH_LONG).show()
                }
                else{
                    result.setText(answer.toString())
                }

            }
            else if(operator == "div"){
                var n1 = 0.0
                var n2 = 0.0

                if(num1.text.toString().startsWith("-")){
                    n1 = num1.text.toString().substring(1).toDouble() * -1
                }
                else{
                    n1 = num1.text.toString().toDouble()
                }
                if(num2.text.toString().startsWith("-")){
                    n2 = num2.text.toString().substring(1).toDouble() * -1
                }
                else{
                    n2 = num2.text.toString().toDouble()
                }

                var answer =
                    ((n1+0.0) /(n2 + 0.0))
                if(answer > Double.MAX_VALUE){
                    Toast.makeText(this, "Number not computable, too large", Toast.LENGTH_LONG).show()
                }
                else{
                    result.setText(answer.toString())
                }

            }

        }
        }
    }