package com.example.bazaar.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bazaar.App
import com.example.bazaar.Manager.SharedPreferencesManager
import com.example.bazaar.R
import com.example.bazaar.Support.TimeStampChecker
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.api.types.Reponse.ProfileDataResponse
import com.example.bazaar.bottomNav
import com.example.bazaar.viewModel.LoginViewModel
import com.example.bazaar.viewModel.LoginViewModelFactory
import com.example.bazaar.viewModel.ProfileView
import com.example.bazaar.viewModel.ProfileViewFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Profile.newInstance] factory method to
 * create an instance of this fragment.
 */
class Profile : Fragment() {
    private val TAG: String = javaClass.simpleName
    var isSuccessful: MutableLiveData<Boolean> = MutableLiveData()

    private lateinit var profileViewModel: ProfileView
    //user data
    var userData: MutableLiveData<ProfileDataResponse> = MutableLiveData()

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
        val usernameTextView:TextureView = view.findViewById(R.id.Profile_view_username)
        val phoneTextView:TextureView = view.findViewById(R.id.Profile_view_phone_number)
        val emailTextView:TextureView = view.findViewById(R.id.Profile_view_email)
        val activatedTextView:TextureView = view.findViewById(R.id.Profile_view_activated)
        val creationTimeTextView:TextureView = view.findViewById(R.id.Profile_view_Creation_time)
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
                    userData.observe(this.viewLifecycleOwner){
                        Log.d(TAG, "Profile = ${userData.value}")

                    }
                }
            }
        }
        else{
            this.findNavController()
                .navigate(ProfileDirections.actionProfileToLogin())
        }
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