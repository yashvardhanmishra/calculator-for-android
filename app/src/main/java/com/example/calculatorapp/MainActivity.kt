package com.example.calculatorapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder


lateinit var one : TextView
lateinit var two : TextView
lateinit var three : TextView
lateinit var four : TextView
lateinit var five : TextView
lateinit var six : TextView
lateinit var seven : TextView
lateinit var eight : TextView
lateinit var nine : TextView


lateinit var equals : TextView
lateinit var plus : TextView
lateinit var minus : TextView
lateinit var devide : TextView
lateinit var multiply : TextView
lateinit var doublezero : TextView
lateinit var zero : TextView
lateinit var point : TextView
lateinit var percentage : TextView
lateinit var Ctext : TextView
lateinit var result : TextView
lateinit var expression : TextView
lateinit var backspace : ImageView






 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one = findViewById<TextView>(R.id.one)
        two = findViewById<TextView>(R.id.two)
        three = findViewById<TextView>(R.id.three)
        four = findViewById<TextView>(R.id.four)
        five = findViewById<TextView>(R.id.five)
        six = findViewById<TextView>(R.id.six)
        seven = findViewById<TextView>(R.id.seven)
        eight = findViewById<TextView>(R.id.eight)
        nine = findViewById<TextView>(R.id.nine)
        doublezero = findViewById<TextView>(R.id.doblezero)
        zero = findViewById<TextView>(R.id.zero)
        plus = findViewById<TextView>(R.id.plus)
        minus = findViewById<TextView>(R.id.minus)
        devide = findViewById<TextView>(R.id.devide)
        multiply = findViewById<TextView>(R.id.multiply)
        percentage = findViewById<TextView>(R.id.percentage)
        equals = findViewById<TextView>(R.id.equals)
        Ctext = findViewById<TextView>(R.id.Ctext)
        backspace = findViewById<ImageView>(R.id.backspace)
        point = findViewById<TextView>(R.id.point)
        result = findViewById<TextView>(R.id.result)
        expression = findViewById<TextView>(R.id.expresion)




        one.setOnClickListener {
            appendText("1", true) }
        two.setOnClickListener {
            appendText("2", true) }
        three.setOnClickListener {
            appendText("3", true) }
        four.setOnClickListener {
            appendText("4", true) }
        five.setOnClickListener {
            appendText("5", true) }
        six.setOnClickListener {
            appendText("6", true) }
        seven.setOnClickListener {
            appendText("7", true) }
        eight.setOnClickListener {
            appendText("8", true) }
        nine.setOnClickListener {
            appendText("9", true) }
        plus.setOnClickListener {
            appendText("+", false) }
        minus.setOnClickListener {
            appendText("-", false) }
        devide.setOnClickListener {
            appendText("/", false) }
        multiply.setOnClickListener {
            appendText("x", false) }
        point.setOnClickListener {
            appendText(".", true) }
        Ctext.setOnClickListener {
            result.text = ""
            expression.text = ""
             }
        backspace.setOnClickListener {
                result.text = ""
            if(expression.text != "" ){
                expression.text = expression.text.substring(0, expression.text.length - 1)
            }

             }

        doublezero.setOnClickListener {
            appendText("00", true) }
        zero.setOnClickListener {
            appendText("0", true) }

        percentage.setOnClickListener {
            appendText("%", false) }




        equals.setOnClickListener {

            try {
                val expr = ExpressionBuilder(expression.text.toString()).build()
                val answer = expr.evaluate()
                result.text = answer.toString()
            }
            catch ( e : Exception )
            {
                result.text = e.message
            }

        }



    }



    private fun appendText(value : String , tobecleared : Boolean) {
        if(result.text != "") {
            expression.text = ""
        }
        if (tobecleared) {
            result.text = ""
            expression.clearComposingText()
            expression.append(value)
        } else {
            expression.append(result.text)
            expression.append(value)
            result.text = ""
        }

    }

}
