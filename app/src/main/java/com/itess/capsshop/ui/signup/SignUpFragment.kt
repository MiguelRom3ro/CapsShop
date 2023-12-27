package com.itess.capsshop.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.itess.capsshop.data.provider.UsersProvider
import android.util.Patterns
import androidx.navigation.fragment.findNavController
import com.itess.capsshop.R
import com.itess.capsshop.data.User
import com.itess.capsshop.databinding.FragmentSignupBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignup.setOnClickListener{
            signUp()
        }

        binding.tvLogin.setOnClickListener{
            navigateLogIn()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Valida que los campos no esten vacios
    private fun validateListET(etList: List<EditText>): Boolean {
        var validation = true

        for (et in etList) {
            val texto = et.text.toString().trim()

            if (texto.isEmpty()) {
                et.error = "Este campo no puede estar vacío"
                validation = false
            } else {
                et.error = null
            }
        }
        return validation
    }

    //Valida que los campos no esten vacios
    private fun validateEt(): Boolean {
        val etList = listOf(
            binding.tiSignupCpassword, binding.tiSignupPassword,
            binding.tiSignupEmail, binding.tiSignupName,
            binding.tiSignupLastname, binding.tiSignupUser
        )
        return validateListET(etList)
    }

    //Realiza las respectivas validaciones antes de registrar al usuario
    private fun signUp(){
        if(validateEt()){
            if(!existUser()){
                if(isEqualPassword()){
                    if(isValidFormat()){
                        val user = User(
                            UsersProvider.getSize(),
                            binding.tiSignupName.text.toString(),
                            binding.tiSignupLastname.text.toString(),
                            binding.tiSignupUser.text.toString(),
                            binding.tiSignupEmail.text.toString(),
                            binding.tiSignupPassword.text.toString())
                        UsersProvider.addUser(user)
                        Toast.makeText(context, "Registrado con exito", Toast.LENGTH_SHORT).show()
                        navigateLogIn()
                    }else{
                        Toast.makeText(context, "Formato invalido", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(context, "Contraseñas distintas", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context, "Ingrese otro nombre de usuario", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(context, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    //Verifica si ya existe el nombre de usuario ingresado
    private fun existUser() : Boolean = UsersProvider.userExistByNameUser(binding.tiSignupUser.text.toString())

    // Función para validar el formato del correo electrónico
    private fun isEmailValid(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    // Función para validar la fortaleza de la contraseña
    private fun isPasswordStrong(password: String): Boolean {
        // Utilizar expresiones regulares para verificar si la contraseña contiene al menos una mayúscula, un número y un carácter especial
        val upperCaseRegex = ".*[A-Z].*"
        val digitRegex = ".*\\d.*"
        val specialCharRegex = ".*[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*"

        return password.matches(upperCaseRegex.toRegex()) &&
                password.matches(digitRegex.toRegex()) &&
                password.matches(specialCharRegex.toRegex())
    }

    //Verifica que las contraseñas sean iguales
    private fun isEqualPassword() : Boolean{
        val password = binding.tiSignupPassword.text.toString()
        val confirmPassword = binding.tiSignupCpassword.text.toString()
        return password == confirmPassword
    }

    //Verifica que el email y las contraseñas tengan el formato deseado
    private fun isValidFormat() : Boolean{
        // Ejemplo de uso en tu código
        val email = binding.tiSignupEmail.text.toString()
        val password = binding.tiSignupPassword.text.toString()

        return isEmailValid(email) && isPasswordStrong(password)
    }

    //Navega a la interfaz Login
    private fun navigateLogIn(){
        findNavController().navigate(R.id.action_nav_signup_to_nav_login)
    }
}