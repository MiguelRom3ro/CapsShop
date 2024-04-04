package com.miguelrr.capsshop.ui.selectedproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

import com.miguelrr.capsshop.databinding.FragmentSelectedProductBinding
import com.miguelrr.capsshop.domain.model.Cap
import com.miguelrr.capsshop.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectedProductFragment : Fragment() {
    private var _binding: FragmentSelectedProductBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val args: SelectedProductFragmentArgs by navArgs()
    private val binding get() = _binding!!
    private val selectedProductViewModel : SelectedProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSelectedProductBinding.inflate(inflater, container, false)
        val root: View = binding.root

        selectedProductViewModel.onCreate(args.idCap)

        selectedProductViewModel.cap.observe(viewLifecycleOwner){
            renderCap(it)
        }

        return root
    }

    private fun renderCap(cap: Cap){
        Glide.with(binding.ivSpProduct.context)
            .load(cap.image)
            .centerCrop()
            .into(binding.ivSpProduct)
        binding.tvSpName.text = cap.name
        binding.tvPriceSp.text = "$${cap.price}"
        binding.tvDescriptionSp.text = cap.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}