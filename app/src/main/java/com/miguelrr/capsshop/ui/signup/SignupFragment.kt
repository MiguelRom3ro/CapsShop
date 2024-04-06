package com.miguelrr.capsshop.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.miguelrr.capsshop.databinding.FragmentSignupBinding
import com.miguelrr.capsshop.domain.model.SignUpUser

class SignupFragment : Fragment() {
    private var _binding: FragmentSignupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val signupViewModel : SignupViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignup.setOnClickListener{
            validateSignUp()
        }

        signupViewModel.responseSignUp.observe(viewLifecycleOwner){
            if(it.status == "succes"){
                Toast.makeText(context, it.reason, Toast.LENGTH_SHORT).show()
                navigateLogin()
            }else{
                Toast.makeText(context, it.reason, Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSignupLogin.setOnClickListener{
            navigateLogin()
        }
    }

    private fun navigateLogin() {
        findNavController().navigate(SignupFragmentDirections.actionNavigationSignupToNavigationLogin())
    }

    private fun validateSignUp() {
        //Verificar que no esten vacios los textinput
        if(!binding.tiSignupName.text.toString().isNullOrEmpty() &&
            !binding.tiSignupLastname.text.toString().isNullOrEmpty() &&
            !binding.tiSignupEmail.text.toString().isNullOrEmpty() &&
            !binding.tiSignupPassword.text.toString().isNullOrEmpty() &&
            !binding.tiSignupCpassword.text.toString().isNullOrEmpty() &&
            !binding.tiSignupUser.text.toString().isNullOrEmpty()){
            //Verificar que la contraseña tenga una longitud mayor o igual a 8
            if(binding.tiSignupPassword.text.toString().length >= 8){
                //Verificar que las contraseñas sean iguales
                if(binding.tiSignupPassword.text.toString() == binding.tiSignupCpassword.text.toString()){
                    callSignUpVM()
                }else{
                    Toast.makeText(context, "Contraseñas distintas", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context, "La contraseña debe contener 8 caracteres como minimo", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(context, "Relleno todos los espacios", Toast.LENGTH_SHORT).show()
        }
    }

    private fun callSignUpVM() {
        val name = binding.tiSignupName.text.toString()
        val lastname = binding.tiSignupLastname.text.toString()
        val email = binding.tiSignupEmail.text.toString()
        val password = binding.tiSignupPassword.text.toString()
        val username = binding.tiSignupUser.text.toString()
        val signUpUser = SignUpUser(name, lastname, email, password, username)

        signupViewModel.signUp(signUpUser)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}