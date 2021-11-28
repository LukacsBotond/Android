package com.example.bazaar.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bazaar.R
import com.example.bazaar.viewModel.LoginViewModel
import com.example.bazaar.viewModel.RegisterViewModel

class Register : Fragment() {

    val TAG: String = javaClass.simpleName

    private lateinit var RegisterViewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)



        // Inflate the layout for this fragment
        return view
    }
}