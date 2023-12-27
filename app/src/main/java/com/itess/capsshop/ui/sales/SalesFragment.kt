package com.itess.capsshop.ui.sales

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.itess.capsshop.adapter.productonsale.ProductOnSaleAdapter
import com.itess.capsshop.data.provider.ProductProvider
import com.itess.capsshop.databinding.FragmentSalesBinding
import com.itess.capsshop.ui.onClickListener

class SalesFragment : Fragment(), onClickListener {

    private var _binding: FragmentSalesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSalesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initRecyclerView()

        return root
    }

    //Esta actividad inicia el RecyclerView
    private fun initRecyclerView(){
        binding.rvSales.layoutManager = LinearLayoutManager(binding.rvSales.context)
        binding.rvSales.adapter = ProductOnSaleAdapter(ProductProvider.getProductsOnSale(), this) // Llamamos a nuestra clase ProductoAdapter.kt
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickProduct(id: Int) {
        findNavController().navigate(
            SalesFragmentDirections.actionNavSalesToNavSelectProduct(id = id)
        )
    }
}