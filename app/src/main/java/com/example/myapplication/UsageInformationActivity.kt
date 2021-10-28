package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UsageInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usage_information)

        findViewById<Button>(R.id.buttonBack).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}