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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import java.lang.StringBuilder
import java.util.jar.Manifest

class QiuzStart : Fragment(R.layout.fragment_qiuz_start) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qiuz_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnClicked = view.findViewById<Button>(R.id.button)
        val contClicked = view.findViewById<Button>(R.id.button2)
        Log.d("mainActivity", "here1")
        btnClicked.setOnClickListener {
            Log.d("mainActivity", "in click listener btn")
            sendMessage()
            Toast.makeText(activity, "Button clicked", Toast.LENGTH_SHORT).show()
            Log.d("mainActivity", "clicked")
        }
        contClicked.setOnClickListener{
            Log.d("mainActivity", "in click listener contBtn")
            val intent = Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI)
            startActivity(intent)
        }
    }

    /** Called when the user taps the Send button */
    private fun sendMessage() {
        /*
        // Do something in response to button
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val message = editText.text.toString()
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
         */
    }
}