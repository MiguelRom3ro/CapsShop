package com.miguelrr.capsshop.ui.shoppingcar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelrr.capsshop.databinding.FragmentShoppingCarBinding
import com.miguelrr.capsshop.domain.listeners.OnClickShoppingCar
import com.miguelrr.capsshop.ui.adapter.shoppingcar.ShoppingCarAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShoppingCarFragment : Fragment(), OnClickShoppingCar {
    private var _binding: FragmentShoppingCarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val shoppingCarViewModel : ShoppingCarViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentShoppingCarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        shoppingCarViewModel.onCreate()

        shoppingCarViewModel.idUser.observe(viewLifecycleOwner){
            if(it == -1){
                navigateLogin()
            }else{
                shoppingCarViewModel.getItems()
            }
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shoppingCarViewModel.items.observe(viewLifecycleOwner){list ->
            if(list.isNotEmpty()){
                binding.rvShoppingcar.layoutManager = LinearLayoutManager(binding.rvShoppingcar.context, LinearLayoutManager.VERTICAL, false)
                binding.rvShoppingcar.adapter = ShoppingCarAdapter(list, this, shoppingCarViewModel)
            }

            //Boton pagar
            binding.btnPay.setOnClickListener{
                if(list.isEmpty()){
                    Toast.makeText(context, "Agregue productos al carrito", Toast.LENGTH_SHORT).show()
                }else{
                    navigatePay()
                }
            }
        }
    }

    private fun navigateLogin() {
        findNavController().navigate(ShoppingCarFragmentDirections.actionNavigationShoppingCarToNavigationLogin())
    }

    private fun navigatePay(){
        findNavController().navigate(ShoppingCarFragmentDirections.actionNavigationShoppingCarToNavigationPay())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickUpdate(amount: Int, id: Int) {
        Toast.makeText(context, "Actualizado con exito", Toast.LENGTH_SHORT).show()
        shoppingCarViewModel.update(amount, id)
    }

    override fun onClickRemove(id: Int) {
        Toast.makeText(context, "Removido con exito", Toast.LENGTH_SHORT).show()
        shoppingCarViewModel.remove(id)
    }
}