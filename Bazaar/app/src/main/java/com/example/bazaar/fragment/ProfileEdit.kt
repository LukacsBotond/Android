package com.example.bazaar.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.bazaar.R
import com.example.bazaar.Support.ProfileData
import com.example.bazaar.Support.TimestamptoDate
import com.example.bazaar.api.types.Reponse.ProfileDataResponse

class ProfileEdit : Fragment() {
    private val TAG: String = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //tv.text = amount.toString()
        val args = arguments?.let { ProfileEditArgs.fromBundle(it) }
        val profileData = args?.profileData
        Log.d(TAG, "Profile Edit $profileData")
        if (profileData != null) {
            setProfileData(view,profileData)
        }



    }

    private fun setProfileData(view: View,profileData: ProfileData){
        Log.d(TAG, "Set Profile")
        val usernameEditText: EditText = view.findViewById(R.id.Profile_view_username)
        val phoneEditText: EditText = view.findViewById(R.id.Profile_view_phone_number)
        val emailEditText: EditText = view.findViewById(R.id.Profile_view_email)
        val activatedTextView: TextView = view.findViewById(R.id.Profile_view_activated)
        val creationTimeTextView: TextView = view.findViewById(R.id.Profile_view_Creation_time)
        val timestampcnv = TimestamptoDate()

        usernameEditText.setText(profileData.username)
        phoneEditText.setText(profileData.phone_number)
        emailEditText.setText(profileData.email)
        activatedTextView.text = profileData.is_activated
        creationTimeTextView.text = timestampcnv.getDateTimeFromEpocLongOfSeconds(profileData.creation_time)
    }

}
