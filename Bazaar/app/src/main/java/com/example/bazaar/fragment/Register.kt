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
import com.example.bazaar.R
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.viewModel.LoginViewModel
import com.example.bazaar.viewModel.RegisterViewModel
import com.example.bazaar.viewModel.RegisterViewModelFactory

class Register : Fragment() {

    val TAG: String = javaClass.simpleName
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = RegisterViewModelFactory(MarketPlaceRepository())
        registerViewModel = ViewModelProvider(this,factory).get(RegisterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val regUsername : EditText = view.findViewById(R.id.Register_Username)
        val password : EditText = view.findViewById(R.id.Register_password)
        val email : EditText = view.findViewById(R.id.Register_Email)
        val phone: EditText = view.findViewById(R.id.Register_Phone)

        val signupButton : Button = view.findViewById(R.id.button_SignUp)

        val loginText: TextView = view.findViewById(R.id.Register_logIn)

        loginText.setOnClickListener{
            this.findNavController().navigate(RegisterDirections.actionRegisterToLogin())
        }

        signupButton.setOnClickListener {
            Log.d(TAG, "Sign up start")
            registerViewModel.username = regUsername.text.toString()
            registerViewModel.password = password.text.toString()
            registerViewModel.email = email.text.toString()
            registerViewModel.phone_number = phone.text.toString()

            registerViewModel.register()

            registerViewModel.isSuccessful.observe(this.viewLifecycleOwner){
                Log.d(TAG, "Succesfull Sign up")
                this.findNavController().navigate(RegisterDirections.actionRegisterToLogin())
            }
        }
    }
}