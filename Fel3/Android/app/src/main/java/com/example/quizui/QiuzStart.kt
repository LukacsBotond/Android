package com.example.quizui

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
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


class QiuzStart : Fragment(R.layout.fragment_qiuz_start) {

    private lateinit var textbox: EditText

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

        textbox = view.findViewById<EditText>(R.id.editTextTextPersonName)

        btnClicked.setOnClickListener {
            sendMessage()
            Toast.makeText(activity, "Button clicked", Toast.LENGTH_SHORT).show()
        }
        contClicked.setOnClickListener{
            /*
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
            getResult.launch(intent)
    */

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
            startActivityForResult(intent, 0)
        }
    }

    // Receiver
    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val contactUri = result.data?.data
            val projection = arrayOf(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER
            )
            val cursor = contactUri?.let {
                requireContext().contentResolver.query(
                    it, projection,
                    null, null, null
                )
            }

            if (cursor != null && cursor.moveToFirst()) {
                val nameIndex =
                    cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                val numberIndex =
                    cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                val name = cursor.getString(nameIndex)
                val number = cursor.getString(numberIndex)

                // do something with name and phone
                Log.d("mainActivity", name + number)
                textbox.setText(name)
            }
            cursor?.close()
        }
    }

        // Receiver
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val contactUri = data?.data ?: return
            val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER)
            val cursor = requireContext().contentResolver.query(contactUri, projection,
                null, null, null)

            if (cursor != null && cursor.moveToFirst()) {
                val nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                //val numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                val name = cursor.getString(nameIndex)
                // do something with name and phone
                Log.d("mainActivity", name)
                textbox.setText(name)
            }
            cursor?.close()
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

    companion object {

        private const val SELECT_PHONE_NUMBER = 111

    }
}