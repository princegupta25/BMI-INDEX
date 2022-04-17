package com.example.bmicalculater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText = findViewById<EditText>(R.id.etHeight)
        val heightText = findViewById<EditText>(R.id.etHeight)
        val calcButton = findViewById<Button>(R.id.btncalc)

        calcButton.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()
            if (weight.isNotEmpty() && height.isNotEmpty()) {

                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

                val bmi2Digits = String.format("%.2f", bmi).toFloat()
                displayResult(bmi2Digits)
            } else {

                Toast.makeText(this, "Please enter the require fields!!", Toast.LENGTH_SHORT).show()

            }
        }
    }
//
//    private fun vTalidateInput(weight:String?,height:String?):Boolean{
//
//        return when{
//            weight.isNullOrEmpty() -> {
//                Toast.makeText( this,"Weight is empty",Toast.LENGTH_LONG).show()
//                return false
//            }
//            height.isNullOrEmpty() -> {
//                Toast.makeText( this,"Height is empty",Toast.LENGTH_LONG).show()
//                return false
//            }
//            else ->{
//                return true
//            }
//
//
//
//        }



    private fun displayResult(bmi:Float){
        val resultIndex = findViewById<TextView>(R.id.tvindex)
        val resultDescription = findViewById<TextView>(R.id.tvresult)
        val info = findViewById<TextView>(R.id.tvinfo)

        resultIndex.text = bmi.toString()
        info.text = "(Normal range is 18 to 24.9)"

        var resultext = ""
        var color = 0

        when{
            bmi<18->{
                resultext = "Underweight"
                color = R.color.underweght
            }
            bmi in 18.00..24.99->{
                resultext = "Healthy"
                color = R.color.normal

            }
            bmi in 25.00..29.99->{
                resultext = "Overweight"
                color = R.color.overweight
            }
            bmi>30->{
                resultext = "Obesse"
                color = R.color.obese

            }
        }
        resultDescription.setTextColor(ContextCompat.getColor(this,color))
        resultDescription.text = resultext



    }

}