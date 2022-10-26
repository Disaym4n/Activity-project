package com.example.activityproject

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activityproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    binding.result.text = result.data?.extras?.get("result").toString()
                }
            }
        val text = binding.emailLayout.editText
        binding.buttonNext.setOnClickListener {
            val intent =
                Intent(this, MainActivity2::class.java)
            intent.putExtra("text", text.toString())
            startForResult.launch(intent)
        }

        binding.buttonNext.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "text.toString()")
                type = "text/plain"
            }

            val viewIntent = Intent(Intent.ACTION_VIEW)
            viewIntent.data = Uri.parse("https://www.google.com")
            startActivity(viewIntent)
        }
    }
}




