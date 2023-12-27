package com.itess.capsshop.ui.shoppingcar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.itess.capsshop.R
import com.itess.capsshop.adapter.shoppingcar.ShoppingCarAdapter
import com.itess.capsshop.data.provider.ShoppingCarProvider
import com.itess.capsshop.data.provider.UsersProvider
import com.itess.capsshop.databinding.FragmentShoppingCarBinding
import com.itess.capsshop.ui.onClickUpdate

class ShoppingCarFragment : Fragment(), onClickUpdate {

    private var _binding: FragmentShoppingCarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPay.setOnClickListener{
            buy()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentShoppingCarBinding.inflate(inflater, container, false)
        val root: View = binding.root
        "$${ShoppingCarProvider.priceTotal()}".also { binding.tvTotalPrice.text = it }
        initRecyclerView()

        return root
    }

    //Esta actividad inicia el RecyclerView
    private fun initRecyclerView(){
        binding.rvShoppingCar.layoutManager = LinearLayoutManager(binding.rvShoppingCar.context)
        binding.rvShoppingCar.adapter = ShoppingCarAdapter(ShoppingCarProvider.getShoppingCarList(), this) // Llamamos a nuestra clase ProductoAdapter.kt
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun update() {
        val price = ShoppingCarProvider.priceTotal()
        val total = String.format("%.2f", price)
        "$${total}".also { binding.tvTotalPrice.text = it }
    }

    private fun buy(){
        if(ShoppingCarProvider.getSize() > 0){
            if(UsersProvider.isOnline()){
                findNavController().navigate(R.id.action_nav_shopping_car_to_nav_pay)
            }else{
                findNavController().navigate(R.id.action_nav_shopping_car_to_nav_login)
            }
        }else{
            Toast.makeText(context, "Agrega productos al carrito", Toast.LENGTH_SHORT).show()
        }
    }
}