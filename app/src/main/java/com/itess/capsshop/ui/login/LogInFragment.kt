package com.itess.capsshop.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itess.capsshop.R
import com.itess.capsshop.data.provider.UsersProvider
import com.itess.capsshop.databinding.FragmentLoginBinding

class LogInFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener{
            validateUser()
        }

        binding.tvSignup.setOnClickListener{
            navigateSignUp()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun validateUser(){
        val userOrEmail = binding.tiInputEmail.text.toString()
        val password = binding.tiInputPassword.text.toString()
        if(UsersProvider.logIn(userOrEmail, password)){
            findNavController().navigate(R.id.action_nav_login_to_nav_pay)
        }else{
            Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateSignUp(){
        findNavController().navigate(R.id.action_nav_login_to_nav_signup)
    }
}