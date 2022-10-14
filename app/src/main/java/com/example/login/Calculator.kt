package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {
    var isNewOP= true
    var oldNumber = ""
    var op ="+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }
    fun numberEvent(view: View) {
        if(isNewOP)
            editText.setText("")
        isNewOP = false
        var buclick =editText.text.toString()
        var buselect =view as Button
        when(buselect.id){
            bu1.id -> {buclick += "1"}
            bu2.id -> {buclick += "2"}
            bu3.id -> {buclick += "3"}
            bu4.id -> {buclick += "4"}
            bu5.id -> {buclick += "5"}
            bu6.id -> {buclick += "6"}
            bu7.id -> {buclick += "7"}
            bu8.id -> {buclick += "8"}
            bu9.id -> {buclick += "9"}
            bu0.id -> {buclick += "0"}
            bu9.id -> {buclick += "1"}
            buDot.id -> {buclick += "."}
            buPlusMinus.id -> {buclick = "-$buclick"}

        }
        editText.setText(buclick)
    }

    fun operatorEvent(view: View) {
        isNewOP = true
        oldNumber= editText.text.toString()
        var buselect = view as Button
        when(buselect.id){
            buMultiply.id -> {op = "*"}
            buplus.id -> {op = "+"}
            buminus.id -> {op = "-"}
            buDivide.id -> {op = "/"}
        }
    }

    fun equalEvent(view: View) {
        var newnumber = editText.text.toString()
        var result = 0.0
        when(op){
            "+" ->{result = oldNumber.toDouble() + newnumber.toDouble()}
            "-" ->{result = oldNumber.toDouble() - newnumber.toDouble()}
            "*" ->{result = oldNumber.toDouble() * newnumber.toDouble()}
            "/" ->{result = oldNumber.toDouble() / newnumber.toDouble()}
        }
        editText.setText(result.toString())
    }

    fun acEvent(view: View) {
        editText.setText("0")
        isNewOP = true


    }

    fun percentEvent(view: View) {
        var no = editText.text.toString().toDouble()/100
        editText.setText(no.toString())
        isNewOP = true
    }

}