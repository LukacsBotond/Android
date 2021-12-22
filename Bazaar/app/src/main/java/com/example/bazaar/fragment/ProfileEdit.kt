package com.example.bazaar.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bazaar.R
import com.example.bazaar.Support.ProfileData
import com.example.bazaar.Support.TimestamptoDate
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.api.types.Reponse.ProfileDataResponse
import com.example.bazaar.bottomNav
import com.example.bazaar.viewModel.LoginViewModel
import com.example.bazaar.viewModel.LoginViewModelFactory
import com.example.bazaar.viewModel.ProfileEditView
import com.example.bazaar.viewModel.ProfileEditViewFactory

class ProfileEdit : Fragment() {
    private val TAG: String = javaClass.simpleName
    private lateinit var profileEditView: ProfileEditView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNav.visibility = View.VISIBLE
        val factory = ProfileEditViewFactory(MarketPlaceRepository())
        profileEditView = ViewModelProvider(this, factory)[ProfileEditView::class.java]
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
            initProfileData(view,profileData)
        }
        val updateButton = view.findViewById<Button>(R.id.Profile_edit_update_button)
        updateButton.setOnClickListener {
            setProfileData(view)
        }
    }

    private fun initProfileData(view: View,profileData: ProfileData){
        Log.d(TAG, "Init edit Profile")
        val usernameEditText: EditText = view.findViewById(R.id.Profile_edit_username)
        val phoneEditText: EditText = view.findViewById(R.id.Profile_edit_phone_number)
        val emailEditText: EditText = view.findViewById(R.id.Profile_edit_email)
        val activatedTextView: TextView = view.findViewById(R.id.Profile_edit_activated)
        val creationTimeTextView: TextView = view.findViewById(R.id.Profile_edit_Creation_time)
        val timestampcnv = TimestamptoDate()

        usernameEditText.setText(profileData.username)
        phoneEditText.setText(profileData.phone_number)
        emailEditText.setText(profileData.email)
        activatedTextView.text = profileData.is_activated
        creationTimeTextView.text = timestampcnv.getDateTimeFromEpocLongOfSeconds(profileData.creation_time)
    }

    private fun setProfileData(view: View){
        Log.d(TAG, "Send edit Profile")
        val usernameEditText: EditText = view.findViewById(R.id.Profile_edit_username)
        val phoneEditText: EditText = view.findViewById(R.id.Profile_edit_phone_number)
        val emailEditText: EditText = view.findViewById(R.id.Profile_edit_email)
        val activatedTextView: TextView = view.findViewById(R.id.Profile_edit_activated)
        val creationTimeTextView: TextView = view.findViewById(R.id.Profile_edit_Creation_time)

        profileEditView.username = usernameEditText.text.toString()
        profileEditView.phone_number = phoneEditText.text.toString()
        profileEditView.email = emailEditText.text.toString()
        profileEditView.updateProfile()

        profileEditView.isSuccessful.observe(this.viewLifecycleOwner) {
            Log.d(TAG, "Profile Updated successfully = $it")
            if(it == true) {
                this.findNavController().navigate(ProfileEditDirections.actionProfileEditToTimeline())
            }
        }
   }


}
