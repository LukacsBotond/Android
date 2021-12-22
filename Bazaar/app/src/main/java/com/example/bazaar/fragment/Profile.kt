package com.example.bazaar.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bazaar.App
import com.example.bazaar.Manager.SharedPreferencesManager
import com.example.bazaar.R
import com.example.bazaar.Support.ProfileData
import com.example.bazaar.Support.TimeStampChecker
import com.example.bazaar.Support.TimestamptoDate
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.api.types.Reponse.ProfileDataResponse
import com.example.bazaar.bottomNav
import com.example.bazaar.viewModel.ProfileView
import com.example.bazaar.viewModel.ProfileViewFactory
import java.util.*

class Profile : Fragment() {
    private val TAG: String = javaClass.simpleName
    //var isSuccessful: MutableLiveData<Boolean> = MutableLiveData()

    private lateinit var profileViewModel: ProfileView
    //user data
    private var userData: MutableLiveData<ProfileDataResponse> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNav.visibility = View.VISIBLE
        val factory = ProfileViewFactory(MarketPlaceRepository())
        profileViewModel = ViewModelProvider(this, factory)[ProfileView::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Profile select")
        val username = App.sharedPreferences.getStringValue(SharedPreferencesManager.USERNAME_TOKEN, "0")
        //timestamp expired?
        val timeStampChecker = TimeStampChecker()
        if(!timeStampChecker.check()) {
            this.findNavController()
                .navigate(ProfileDirections.actionProfileToLogin())
        }
        //username Check
        if(username == "0"){
            this.findNavController()
                .navigate(ProfileDirections.actionProfileToLogin())
        }
        if (username!= null) {
            profileViewModel.username = username
            profileViewModel.getProfile()
            profileViewModel.isSuccessful.observe(this.viewLifecycleOwner){
                Log.d(TAG, "Got profile successfully = $it")
                if(it == true){
                    profileViewModel.userData.observe(this.viewLifecycleOwner){ it1->
                        if(username == it1.username){
                            val profileData =  ProfileData(it1.username,it1.phone_number,it1.email,it1.is_activated,it1.creation_time)
                            //val action = ProfileDirections.actionProfileToProfileEdit(it1)
                            this.findNavController()
                                .navigate(ProfileDirections.actionProfileToProfileEdit(profileData))
                        }
                        setProfileData(view,it1)
                    }
                }
            }
        }
        else{
            this.findNavController()
                .navigate(ProfileDirections.actionProfileToLogin())
        }
    }

    private fun setProfileData(view: View,profileDataResponse: ProfileDataResponse){
        Log.d(TAG, "Set Profile")
        val usernameTextView: TextView = view.findViewById(R.id.Profile_view_username)
        val phoneTextView:TextView = view.findViewById(R.id.Profile_view_phone_number)
        val emailTextView:TextView = view.findViewById(R.id.Profile_view_email)
        val activatedTextView:TextView = view.findViewById(R.id.Profile_view_activated)
        val creationTimeTextView:TextView = view.findViewById(R.id.Profile_view_Creation_time)
        val timestampcnv = TimestamptoDate()

        usernameTextView.text = profileDataResponse.username
        phoneTextView.text = profileDataResponse.phone_number
        emailTextView.text = profileDataResponse.email
        activatedTextView.text = profileDataResponse.is_activated
        creationTimeTextView.text = timestampcnv.getDateTimeFromEpocLongOfSeconds(profileDataResponse.creation_time)
    }



/*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Profile.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

 */
}