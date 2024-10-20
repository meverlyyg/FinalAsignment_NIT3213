package com.vu.androidbasicapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.vu.androidbasicapp.home.ui.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
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

        val usernameEditText: EditText = view.findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = view.findViewById(R.id.passwordEditText)
        val loginButton: Button = view.findViewById(R.id.loginButton)

        // Observe loginResult from the ViewModel
        // Set up the login button click listener
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Call the login method
                viewModel.login(username, password)
            } else {
                Toast.makeText(requireContext(), "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
        }

        // Observe the login response
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response != null) {
            // Handle successful login
            Toast.makeText(requireContext(), "Login successful: ${response.keypass}", Toast.LENGTH_SHORT).show()
            // Navigate to the DashboardFragment
            findNavController().navigate(R.id.action_loginFragment_to_HomeScreenFragment)
        }
            })

        viewModel.loginError.observe(viewLifecycleOwner, Observer { error ->
            // Handle login error
            Toast.makeText(requireContext(), "Login failed: $error", Toast.LENGTH_SHORT).show()
        })
    }
}
