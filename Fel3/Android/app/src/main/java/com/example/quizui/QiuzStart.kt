package com.example.quizui

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
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit


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
            Log.d("mainActivity", "Button clicked")
            Toast.makeText(activity, "Button clicked", Toast.LENGTH_SHORT).show()
        }
        contClicked.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
            getResult.launch(intent)
        }
    }

    // Receiver
    private val getResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
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

    /** Called when the user taps the Send button */
    private fun sendMessage() {
        val fr = parentFragmentManager.beginTransaction()
        fr.replace(R.id.fragment_qiuz_start, QuizFragment())
        fr.commit()
    }
    companion object {

        private const val SELECT_PHONE_NUMBER = 111

    }
}