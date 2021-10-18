package com.example.quizui

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import java.lang.StringBuilder
import java.util.jar.Manifest


const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    /*
    private val getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK){
            val contracUri = result.data?.data
            if(contracUri != null){
                var projection = arrayOf(
                    ContractsContract.C
                )
            }
        }
    }
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClicked = findViewById<Button>(R.id.button)
        val contClicked = findViewById<Button>(R.id.button2)



        btnClicked.setOnClickListener {
            sendMessage()
            Toast.makeText(this@MainActivity, "Button clicked", Toast.LENGTH_SHORT).show()
            Log.i("mainActivity", "clicked")
        }

        contClicked.setOnClickListener{
            var intent = Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI)
            startActivity(intent)
        }
    }


    /** Called when the user taps the Send button */
    private fun sendMessage() {
        // Do something in response to button
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val message = editText.text.toString()
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}