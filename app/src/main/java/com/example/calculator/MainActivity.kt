package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var inputbox:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputbox=findViewById(R.id.inputbox)
    }
    var dot:Boolean=false
    var newop:Boolean=true

    var operator:String="X"
    var oldNum:String=""

    fun getNumbers(view: View) {
        if (newop) {
            inputbox.text = ""
        }
        newop = false
        var getText: String = inputbox.text.toString()

        val selectedBtn = view as Button
        when (selectedBtn.id) {
            R.id.btn0 -> {
                getText += "0"
            }
            R.id.btn1 -> {
                getText += "1"
            }
            R.id.btn2 -> {
                getText += "2"
            }
            R.id.btn3 -> {
                getText += "3"
            }
            R.id.btn4 -> {
                getText += "4"
            }
            R.id.btn5 -> {
                getText += "5"
            }
            R.id.btn6 -> {
                getText += "6"
            }
            R.id.btn7 -> {
                getText += "7"
            }
            R.id.btn8 -> {
                getText += "8"
            }
            R.id.btn9 -> {
                getText += "9"
            }
            R.id.btndot -> {
                if (!dot) {
                    getText += "."
                }
                dot = true
            }
        }
        inputbox.text = getText
    }
    fun getOperator(view: View){
        val selectedOp=view as Button
        when(selectedOp.id){
            R.id.btnadd->{
                operator= "+"
            }
            R.id.btnsub->{
                operator="="
            }
            R.id.btnmultiply->{
                operator="x"
            }
            R.id.btndivide->{
                operator="/"
            }
        }
        oldNum=inputbox.text.toString()
        dot=false
        newop=true
    }
    fun equaloperator(view: View){
        val newNum=inputbox.text.toString()
        var result:Double?=null
        when(operator){
            "x"->{
                result=oldNum.toDouble() * newNum.toDouble()
            }
            "+"->{
                result=oldNum.toDouble() + newNum.toDouble()
            }
            "-"->{
                result=oldNum.toDouble() - newNum.toDouble()
            }
            "/"->{
                result=oldNum.toDouble() / newNum.toDouble()
            }
        }
        inputbox.text=result.toString()
    }
    fun cleanInput(view: View){
        inputbox.text=""
        newop=true
        dot=false
    }
}
