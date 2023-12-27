package com.itess.capsshop.ui.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.itess.capsshop.R
import com.itess.capsshop.data.provider.ShoppingCarProvider
import com.itess.capsshop.databinding.FragmentPayBinding

class PayFragment : Fragment(){

    private var _binding: FragmentPayBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPayPay.setOnClickListener{
            navigateCheckoutCompleted()
            ShoppingCarProvider.clearShoppingCarList()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPayBinding.inflate(inflater, container, false)
        val root: View = binding.root
        getInfoProducts()

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun validateET(etList: List<EditText>): Boolean {
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

    private fun navigateCheckoutCompleted(){
        val etList = listOf(
            binding.tiNameDirection, binding.tiLastnameDirection,
            binding.tiCpDirection, binding.tiColoniaDirection,
            binding.tiStreetDirection, binding.tiNumberDirection)
        val validation = validateET(etList)

        if (validation) {
            findNavController().navigate(R.id.action_nav_pay_to_nav_checkeout_completed)
        } else {
            Toast.makeText(context, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getInfoProducts(){
        val item = ShoppingCarProvider.getFirstItem()
        if(ShoppingCarProvider.getSize() == 1){
            binding.tvProductPay.text = item.name
            binding.tvAmountPay.text = "${ShoppingCarProvider.getAmount()}"
            binding.tvTotalPay.text = "${ShoppingCarProvider.priceTotal()}"
            Glide.with(binding.ivProductPay.context).load(
                item.img).into(binding.ivProductPay)
        }else{
            "+${ShoppingCarProvider.getSize()} productos".also { binding.tvProductPay.text = it }
            binding.tvAmountPay.text = "${ShoppingCarProvider.getAmount()}"
            binding.tvTotalPay.text = "${ShoppingCarProvider.priceTotal()}"
            Glide.with(binding.ivProductPay.context).load(
                item.img).into(binding.ivProductPay)
        }
    }
}