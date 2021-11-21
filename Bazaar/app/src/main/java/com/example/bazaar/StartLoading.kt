package com.example.bazaar

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

class StartLoading : Fragment() {
    private lateinit var spinner: ProgressBar


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
            this.findNavController()
                .navigate(StartLoadingDirections.actionStartLoadingToLogin())
        }, 3000)
    }
}