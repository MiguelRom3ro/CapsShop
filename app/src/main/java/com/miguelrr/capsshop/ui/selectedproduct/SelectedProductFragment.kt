package com.miguelrr.capsshop.ui.selectedproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.miguelrr.capsshop.CapsShopApp.Companion.idUserSP
import com.miguelrr.capsshop.databinding.FragmentSelectedProductBinding
import com.miguelrr.capsshop.domain.model.Cap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectedProductFragment : Fragment() {
    private var _binding: FragmentSelectedProductBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val args: SelectedProductFragmentArgs by navArgs()
    private val binding get() = _binding!!
    private val selectedProductViewModel : SelectedProductViewModel by viewModels()
    var amount = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSelectedProductBinding.inflate(inflater, container, false)
        val root: View = binding.root

        selectedProductViewModel.onCreate(args.idCap)

        selectedProductViewModel.cap.observe(viewLifecycleOwner){cap ->
            renderCap(cap)
            binding.btnAddCarSp.setOnClickListener{
                selectedProductViewModel.verify(cap.id)
                selectedProductViewModel.verifySP.observe(viewLifecycleOwner){verify ->
                    if(idUserSP.getId() != -1){
                        if(!verify){
                            selectedProductViewModel.addItemSC(amount, cap.id)
                            Toast.makeText(context, "Articulo agregado con exito", Toast.LENGTH_SHORT).show()
                            navigateShoppingCar()
                        }else{
                            Toast.makeText(context, "Articulo agregado previamente", Toast.LENGTH_SHORT).show()
                            navigateShoppingCar()
                        }
                    }else{
                        Toast.makeText(context, "Inicie sesión", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            selectedProductViewModel.amount.observe(viewLifecycleOwner){
                amount = it
                binding.tvAmountSp.text = "$amount"
            }
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivSubstractSp.setOnClickListener{
            selectedProductViewModel.lessItem()
        }

        binding.ivPlusSp.setOnClickListener{
            selectedProductViewModel.plusItem()
        }
    }

    private fun navigateShoppingCar(){
        findNavController().navigate(SelectedProductFragmentDirections.actionNavigationSelectedProductToNavigationShoppingCar())
    }
    private fun renderCap(cap: Cap){
        Glide.with(binding.ivSpProduct.context)
            .load(cap.image)
            .centerCrop()
            .into(binding.ivSpProduct)
        binding.tvSpName.text = cap.name
        "$${cap.price}".also { binding.tvPriceSp.text = it }
        binding.tvDescriptionSp.text = cap.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}