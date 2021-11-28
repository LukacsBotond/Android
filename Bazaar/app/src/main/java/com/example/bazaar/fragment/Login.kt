package com.example.bazaar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bazaar.Manager.SharedPreferencesManager
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.viewModel.LoginViewModel
import com.example.bazaar.viewModel.LoginViewModelFactory


class Login : Fragment() {

    val TAG: String = javaClass.simpleName

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = LoginViewModelFactory(MarketPlaceRepository())
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userNameEditText: EditText = view.findViewById(R.id.edittext_name_login_fragment)
        val passwordEditText: EditText = view.findViewById(R.id.edittext_password_login_fragment)
        val SignInButton: Button = view.findViewById(R.id.button_LogIn)

        val SignUpButton: Button = view.findViewById(R.id.button_SignUp)

        Log.d(TAG, "token = "  + App.sharedPreferences.getStringValue(SharedPreferencesManager.KEY_TOKEN, "Empty token!"))

        SignInButton.setOnClickListener {
            loginViewModel.username = userNameEditText.text.toString()
            loginViewModel.password = passwordEditText.text.toString()

            loginViewModel.login()

            loginViewModel.isSuccessful.observe(this.viewLifecycleOwner) {
                Log.d(TAG, "Logged in successfully = " + it)
                this.findNavController().navigate(LoginDirections.actionLoginToTimeline())
            }
        }

        SignUpButton.setOnClickListener{
            this.findNavController().navigate(LoginDirections.actionLoginToRegister())
        }


    }
}