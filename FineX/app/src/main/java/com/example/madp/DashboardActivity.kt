package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madp.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button9.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.button7.setOnClickListener {
            startActivity(Intent(this, Post1Activity::class.java))
        }

        binding.button8.setOnClickListener {
            startActivity(Intent(this, Payment1Activity::class.java))
        }

        binding.button.setOnClickListener {
            startActivity(Intent(this, ApplyJob1Activity::class.java))
        }
    }
}