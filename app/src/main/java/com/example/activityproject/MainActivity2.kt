package com.example.activityproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityproject.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.extras?.get("text").toString()

        binding.textView.text = text

        binding.done.setOnClickListener {
            setResult(RESULT_OK, Intent().apply {
                putExtra("result", binding.inputLayout.editText.toString())
            })
            finish()
        }
    }
}