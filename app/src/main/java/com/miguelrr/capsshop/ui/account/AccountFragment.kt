package com.miguelrr.capsshop.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.miguelrr.capsshop.CapsShopApp.Companion.idUserSP
import com.miguelrr.capsshop.databinding.FragmentAccountBinding
import com.miguelrr.capsshop.domain.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val accountViewModel : AccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root

        accountViewModel.onCreate()

        accountViewModel.idUser.observe(viewLifecycleOwner){
            if(it == -1){
                navigateLogIn()
            }else{
                accountViewModel.getUser(it)
            }
        }

        accountViewModel.user.observe(viewLifecycleOwner){
            renderUser(it)
        }

        binding.btnAccountLogout.setOnClickListener{
            idUserSP.logOut()
            navigateHome()
        }

        return root
    }

    private fun renderUser(user : User) {
        binding.tvAccountUsername.text = user.username
        "${user.name} ${user.lastName}".also { binding.tvAccountName.text = it }
        binding.tvAccountEmail.text = user.email
    }

    private fun navigateLogIn() {
        findNavController().navigate(AccountFragmentDirections.actionNavigationAccountToNavigationLogin())
    }

    private fun navigateHome() {
        findNavController().navigate(AccountFragmentDirections.actionNavigationAccountToNavigationHome())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}