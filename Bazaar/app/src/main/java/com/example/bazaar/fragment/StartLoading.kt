package com.example.bazaar

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import com.example.bazaar.Manager.SharedPreferencesManager
import java.time.Instant

class StartLoading : Fragment() {
    private val TAG: String = javaClass.simpleName
    private lateinit var spinner: ProgressBar
    private var needsLogin = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val layout =  inflater.inflate(R.layout.fragment_start_loading, container, false)
        return layout
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("mainActivity", "Bazaar start")
        Handler(Looper.getMainLooper()).postDelayed({

            var timeInt:Long = 0
            var timeOutInt:Long = 0
            val currentTime = System.currentTimeMillis()
            var cTime = App.sharedPreferences.getStringValue(SharedPreferencesManager.CREATE_TIME_TOKEN, "0")
            var rTime = App.sharedPreferences.getStringValue(SharedPreferencesManager.TIMEOUT_TOKEN, "0")
            if (cTime == null)
                cTime = "0"
            if (rTime == null)
                rTime = "0"
            try {
                timeInt = cTime.toLong()
            } catch (nfe: NumberFormatException) {
                needsLogin = true
            }
            try {
                timeOutInt = rTime.toLong()
            } catch (nfe: NumberFormatException) {
                needsLogin = true
            }

            //new phone
            if (timeInt == 0.toLong() || timeOutInt == 0.toLong()){
                needsLogin = true
            }else{
                needsLogin = timeInt + timeOutInt <= currentTime
            }
            Log.d(TAG, "timestamp = $timeInt")
            Log.d(TAG, "refrest = $timeOutInt")
            Log.d(TAG, "currentTime = $currentTime")
            if(needsLogin){
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