package com.example.bazaar.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.bazaar.App
import com.example.bazaar.Manager.SharedPreferencesManager
import com.example.bazaar.R
import com.example.bazaar.Support.TimeStampChecker
import com.example.bazaar.bottomNav

class StartLoading : Fragment() {
    private val TAG: String = javaClass.simpleName
    private lateinit var spinner: ProgressBar
    private var needsLogin = true
    private var noToken = true
    private var noName = true
    var token: MutableLiveData<String> = MutableLiveData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bottomNav.visibility = View.INVISIBLE
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_start_loading, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Bazaar start")
        Handler(Looper.getMainLooper()).postDelayed({

            //var timeInt:Long = 0
            //var timeOutInt:Long = 0
            //val currentTime = System.currentTimeMillis()
            val username = App.sharedPreferences.getStringValue(SharedPreferencesManager.USERNAME_TOKEN, "0")
            val tokenRead = App.sharedPreferences.getStringValue(SharedPreferencesManager.KEY_TOKEN, "0")
            //var cTime = App.sharedPreferences.getStringValue(SharedPreferencesManager.CREATE_TIME_TOKEN, "0")
            //var rTime = App.sharedPreferences.getStringValue(SharedPreferencesManager.TIMEOUT_TOKEN, "0")
            //TOKEN
            if(tokenRead != "0"){
                token.value = tokenRead
                noToken = false
                Log.d(TAG, "token = ${token.value}")
            }
            //username Check
            if(username != "0"){
                noName = false
            }

            val timeStampChecker = TimeStampChecker()
            needsLogin = timeStampChecker.check()
            //invert it
            needsLogin = !needsLogin
            Log.d(TAG, "NeedsLogin   = $needsLogin")
            Log.d(TAG, "NoToken   = $noToken")
            Log.d(TAG, "NoName   = $noName")


            if(needsLogin || noToken || noName){
                this.findNavController()
                    .navigate(StartLoadingDirections.actionStartLoadingToLogin())
            }
            else{
                this.findNavController()
                    .navigate(StartLoadingDirections.actionStartLoadingToTimeline())
            }
        }, 3000)
    }
}