package com.example.bazaar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bazaar.R
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.bottomNav
import com.example.bazaar.viewModel.ForgotPasswordViewModel
import com.example.bazaar.viewModel.ForgotPasswordViewModelFactory

class ForgotPassword : Fragment() {

    val TAG: String = javaClass.simpleName

    private lateinit var forgotViewModel: ForgotPasswordViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNav.visibility = View.INVISIBLE
        val factory = ForgotPasswordViewModelFactory(MarketPlaceRepository())
        forgotViewModel = ViewModelProvider(this, factory)[ForgotPasswordViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frogot_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}