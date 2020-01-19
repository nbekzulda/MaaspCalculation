package com.example.maaspcalculation


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_second.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment(){



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_second, container, false)

        //numbers
        val zero: Button = view.findViewById(R.id.buttonNumber0)
        val one: Button = view.findViewById(R.id.buttonNumber1)
        val two: Button = view.findViewById(R.id.buttonNumber2)
        val three: Button = view.findViewById(R.id.buttonNumber3)
        val four: Button = view.findViewById(R.id.buttonNumber4)
        val five: Button = view.findViewById(R.id.buttonNumber5)
        val six: Button = view.findViewById(R.id.buttonNumber6)
        val seven: Button = view.findViewById(R.id.buttonNumber7)
        val eight: Button = view.findViewById(R.id.buttonNumber8)
        val nine: Button = view.findViewById(R.id.buttonNumber9)
        val dot: Button = view.findViewById(R.id.buttonDot)
        val open: Button = view.findViewById(R.id.buttonOpen)
        val close: Button = view.findViewById(R.id.buttonClose)

        zero.setOnClickListener { appendOnExpression("0", true) }
        one.setOnClickListener { appendOnExpression("1", true) }
        two.setOnClickListener { appendOnExpression("2", true) }
        three.setOnClickListener { appendOnExpression("3", true) }
        four.setOnClickListener { appendOnExpression("4", true) }
        five.setOnClickListener { appendOnExpression("5", true) }
        six.setOnClickListener { appendOnExpression("6", true) }
        seven.setOnClickListener { appendOnExpression("7", true) }
        eight.setOnClickListener { appendOnExpression("8", true) }
        nine.setOnClickListener { appendOnExpression("9", true) }
        dot.setOnClickListener { appendOnExpression(".", true) }
        open.setOnClickListener { appendOnExpression("(", true) }
        close.setOnClickListener { appendOnExpression(")", true) }

        //operators
        val plus: Button = view.findViewById(R.id.buttonPlus)
        val minus: Button = view.findViewById(R.id.buttonMinus)
        val divide: Button = view.findViewById(R.id.buttonDivide)
        val multiply: Button = view.findViewById(R.id.buttonMultiply)
        val clear:Button = view.findViewById(R.id.buttonClear)
        val delete: ImageView = view.findViewById(R.id.buttonDelete)
        val equal: Button = view.findViewById(R.id.buttonResult)
        val power: ImageView = view.findViewById(R.id.buttonFactorial)
        val sin: Button = view.findViewById(R.id.buttonSin)
        val cos: Button = view.findViewById(R.id.buttonCos)
        val percent: ImageView = view.findViewById(R.id.buttonMod)
        val root: ImageView = view.findViewById(R.id.buttonSqrt)



        plus.setOnClickListener {
            if(output.text.toString().isNotEmpty()){
                numberInput.text = ""
            }
            appendOnExpression("+", false)
        }
        minus.setOnClickListener {
            if(output.text.toString().isNotEmpty()){
                numberInput.text = ""
            }
            appendOnExpression("-", false)
        }
        divide.setOnClickListener {
            if(output.text.toString().isNotEmpty()){
                numberInput.text = ""
            }
            appendOnExpression("/", false)
        }
        multiply.setOnClickListener {
            if(output.text.toString().isNotEmpty()){
                numberInput.text = ""
            }
            appendOnExpression("*", false)
        }

        power.setOnClickListener {

            if(output.text.toString().isNotEmpty()){
                numberInput.text = ""
            }
            appendOnExpression("^", false)

        }

        sin.setOnClickListener {
            if(output.text.toString().isNotEmpty()){
                numberInput.text = ""
            }
            appendOnExpression("sin", false)
        }

        cos.setOnClickListener {
            if(output.text.toString().isNotEmpty()){
                numberInput.text = ""
            }
            appendOnExpression("cos", false)
        }

        percent.setOnClickListener {
            if(output.text.toString().isNotEmpty()){
                numberInput.text = ""
            }
            appendOnExpression("e", false)
//            if(output.text.toString().isNotEmpty()){
//                numberInput.text = ""
//            }
//
//
//            var perc: Float
//
//
//            if(output.text.toString().isNotEmpty()) {
//                perc = output.text.toString().toFloat()
//            }
//            else {
//                perc = numberInput.text.toString().toFloat()
//            }
//            val perc1: Float = perc/100
//            output.text = perc1.toString()


        }


        root.setOnClickListener {

            if(output.text.toString().isNotEmpty()){
                numberInput.text = ""
            }
            appendOnExpression("sqrt", false)
//            if(numberInput.text.toString().isNotEmpty()){
//                val num1 = numberInput.text.toString().toDouble()
//                output.text = Math.sqrt(num1).toString()
//
//            }
//            else{
//                output.setText("no value")
//            }
        }

        clear.setOnClickListener {
            numberInput.text = ""
            output.text = ""

        }

        delete.setOnClickListener {
            val string = numberInput.text.toString()
            if(string.isNotEmpty()){
                numberInput.text = string.substring(0, string.length - 1)

            }
            output.text = ""



        }

        equal.setOnClickListener {
            try {
                val expression = ExpressionBuilder(numberInput.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if(result == longResult.toDouble())
                    output.text = longResult.toString()
                else
                    output.text = result.toString()
            }
            catch (e: Exception){
                Log.d("Exception", "message : " + e.message)

            }
        }

        return view

    }

    fun factorial(){
        val numString = numberInput.text.toString()
        val num2String = output.text.toString()
        val numInt: Int
        if(numberInput.text.isNotEmpty()){
            numInt = numString.toInt()
        }
        else{
            numInt = num2String.toInt()
        }

        var Factorial: Long = 1
        for (i in 1..numInt) {
            // factorial = factorial * i;
            Factorial *= i.toLong()
        }
        output.text = Factorial.toString()
    }

    fun appendOnExpression(string: String, canClear: Boolean){
        if(canClear){
            output.text = ""
            numberInput.append(string)
        }
        else {
            numberInput.append(output.text)
            numberInput.append(string)
            output.text = ""

        }
    }


}

