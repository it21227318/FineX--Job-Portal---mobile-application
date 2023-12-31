package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madp.databinding.ActivityApplyJob1Binding

class ApplyJob1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityApplyJob1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApplyJob1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4.setOnClickListener {
            startActivity(Intent(this, ApplyJob2Activity::class.java))
        }
        binding.button5.setOnClickListener {
            startActivity(Intent(this, ApplyJob2Activity::class.java))
        }
    }
}