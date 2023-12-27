package com.itess.capsshop.ui.selectproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.itess.capsshop.R
import com.itess.capsshop.data.provider.ProductProvider
import com.itess.capsshop.data.provider.ShoppingCarProvider
import com.itess.capsshop.databinding.FragmentSelectProductBinding

class SelectProductFragment : Fragment() {

    private val args: SelectProductFragmentArgs by navArgs()

    private var _binding: FragmentSelectProductBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddCarSp.setOnClickListener{
            addShoppingCar()
        }
        binding.ivPlusSp.setOnClickListener{
            addProduct()
        }
        binding.ivSubstractSp.setOnClickListener{
            substractProduct()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSelectProductBinding.inflate(inflater, container, false)
        showProduct()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun addShoppingCar(){
        val idProduct = args.id
        val amount = binding.tvAmountSp.text.toString().toInt()
        ShoppingCarProvider.addProduct(idProduct, amount)
        Toast.makeText(context, "Agregado con exito", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_nav_select_product_to_nav_shopping_car)
    }

    private fun addProduct(){
        var amount = binding.tvAmountSp.text.toString().toInt()
        if(amount >= 10){
            Toast.makeText(context, "Limite alcanzado", Toast.LENGTH_SHORT).show()
        }else{
            amount++
            binding.tvAmountSp.text = amount.toString()
        }
    }

    private fun showProduct(){
        val idProduct = args.id
        val product = ProductProvider.getProduct(idProduct)
        binding.tvNameSp.text = product?.name
        if(product?.onSale == true){
            val priceOnSale = product.price - (product.price * (product.discount/100))
            "$$priceOnSale".also { binding.tvPriceSp.text = it }
            binding.tvPriceBeforeSp.visibility = View.VISIBLE
            "$${product.price}".also { binding.tvPriceBeforeSp.text = it }
        }else{
            "$${product?.price}".also { binding.tvPriceSp.text = it }
        }
        binding.tvDescriptionSp.text = product?.description
        Glide.with(binding.ivProductSp.context).load(product?.img).into(binding.ivProductSp)
    }

    private fun substractProduct(){
        var amount = binding.tvAmountSp.text.toString().toInt()
        if(amount <= 1){
            Toast.makeText(context, "Opcion invalida", Toast.LENGTH_SHORT).show()
        }else{
            amount--
            binding.tvAmountSp.text = amount.toString()
        }
    }
}