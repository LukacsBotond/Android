package com.example.quizui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClicked = findViewById<Button>(R.id.button)

        btnClicked.setOnClickListener {

            Toast.makeText(this@MainActivity, "Button clicked", Toast.LENGTH_SHORT).show()
            Log.i("mainActivity","clicked")
        }
    }
}