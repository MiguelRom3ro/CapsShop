package com.miguelrr.capsshop.ui.shoppingcar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.miguelrr.capsshop.databinding.FragmentShoppingCarBinding

class ShoppingCarFragment : Fragment() {
    private var _binding: FragmentShoppingCarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val shoppingCarViewModel =
            ViewModelProvider(this).get(ShoppingCarViewModel::class.java)

        _binding = FragmentShoppingCarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}