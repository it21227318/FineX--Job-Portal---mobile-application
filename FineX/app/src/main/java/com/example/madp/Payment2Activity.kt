package com.example.madp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityPayment2Binding

class Payment2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPayment2Binding
    private val PICK_IMAGE_REQUEST = 1
    private lateinit var selectedImageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPayment2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val pmethod = intent.getStringExtra("pmethod")
        val total = intent.getStringExtra("total")
        val ads = intent.getStringExtra("ads")

        binding.editTextTextPersonName8.text = pmethod
        binding.editTextTextPersonName5.text = total

        binding.button4.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        binding.button5.setOnClickListener {
            binding.imageView.setImageURI(null)
            binding.editTextTextPersonName4.text = "No file chosen"
            selectedImageUri = Uri.EMPTY
        }

        binding.button6.setOnClickListener {
            val pmethod = intent.getStringExtra("pmethod")
            val total = intent.getStringExtra("total")
            val ads = intent.getStringExtra("ads")

            val intent = Intent(this, EditPaymentActivity::class.java)
            intent.putExtra("pmethod", pmethod)
            intent.putExtra("total", total)
            intent.putExtra("ads", ads)

            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            selectedImageUri = data.data!!
            binding.imageView.setImageURI(selectedImageUri)
            binding.editTextTextPersonName4.text = selectedImageUri.toString()
        } else {
            Toast.makeText(this, "Upload the payment proof !", Toast.LENGTH_SHORT).show()
        }

        binding.button3.setOnClickListener {
            if (selectedImageUri != Uri.EMPTY){
                startActivity(Intent(this, DashboardActivity::class.java))
                Toast.makeText(this, "Payment Successful !", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Upload the payment proof !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
