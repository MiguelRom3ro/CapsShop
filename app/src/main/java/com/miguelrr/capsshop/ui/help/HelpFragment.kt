package com.miguelrr.capsshop.ui.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.miguelrr.capsshop.databinding.FragmentHelpBinding
import com.miguelrr.capsshop.databinding.FragmentHomeBinding
import com.miguelrr.capsshop.ui.home.HomeViewModel

class HelpFragment : Fragment() {

    private var _binding: FragmentHelpBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HelpViewModel::class.java]

        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvHelp
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}