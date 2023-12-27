package com.itess.capsshop.ui.checkoutcompleted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itess.capsshop.R
import com.itess.capsshop.databinding.FragmentCheckoutCompletedBinding

class CheckoutCompletedFragment : Fragment(){

    private var _binding: FragmentCheckoutCompletedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoHome.setOnClickListener{
            goHome()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCheckoutCompletedBinding.inflate(inflater, container, false)


        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun goHome(){
        // Obtén el NavController
        val navController = findNavController()
// Navega de nuevo al fragmento de inicio (home)
        navController.popBackStack(R.id.nav_home, false)
    }
}