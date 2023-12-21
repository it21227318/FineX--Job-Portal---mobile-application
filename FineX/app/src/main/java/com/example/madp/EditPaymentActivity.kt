package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityEditPaymentBinding

class EditPaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from intent extras
        val pmethod = intent.getStringExtra("pmethod")
        val total = intent.getStringExtra("total")
        val ads = intent.getStringExtra("ads")

        binding.editTextTextPersonName7.setText(pmethod)
        binding.editTextTextPersonName9.setText(ads)

        binding.button3.setOnClickListener {
            val updatedpmethod = binding.editTextTextPersonName7.text.toString()
            val updatedads = binding.editTextTextPersonName9.text.toString()

            if (updatedpmethod.isNotEmpty() && updatedads.isNotEmpty()) {
                val num1 = binding.editTextTextPersonName4.text.toString().toInt()
                val num2 = binding.editTextTextPersonName.text.toString().toInt()
                val updatedads = binding.editTextTextPersonName9.text.toString().toIntOrNull()

                if (updatedads != null) {
                    val sum = (num1*updatedads) + num2
                    val profileIntent = Intent(this, Payment2Activity::class.java)
                    profileIntent.putExtra("pmethod", updatedpmethod)
                    profileIntent.putExtra("total", sum.toString())
                    profileIntent.putExtra("ads", updatedads.toString())
                    startActivity(profileIntent)
                } else {
                    Toast.makeText(this, "Please enter a valid number !", Toast.LENGTH_SHORT).show()
                }
                Toast.makeText(this, "Your details updated successfully !", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}