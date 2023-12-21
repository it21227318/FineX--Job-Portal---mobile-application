package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityPayment1Binding

class Payment1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPayment1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPayment1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            val pmethod = binding.editTextTextPersonName7.text.toString()

            if(pmethod.isNotEmpty()){
                val num1 = binding.editTextTextPersonName4.text.toString().toInt()
                val num2 = binding.editTextTextPersonName.text.toString().toInt()
                val num3 = binding.editTextTextPersonName9.text.toString().toIntOrNull()

                if (num3 != null) {
                    val sum = (num1*num3) + num2
                    val profileIntent = Intent(this, Payment2Activity::class.java)
                    profileIntent.putExtra("pmethod", pmethod)
                    profileIntent.putExtra("total", sum.toString())
                    profileIntent.putExtra("ads", num3.toString())
                    startActivity(profileIntent)
                } else {
                    Toast.makeText(this, "Please enter a valid number !", Toast.LENGTH_SHORT).show()
                }

            } else{
                Toast.makeText(this, "Enter a payment method !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}