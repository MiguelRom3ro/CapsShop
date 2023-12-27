package com.itess.capsshop.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.itess.capsshop.adapter.product.ProductAdapter
import com.itess.capsshop.data.provider.ProductProvider
import com.itess.capsshop.databinding.FragmentProductBinding
import com.itess.capsshop.ui.onClickListener

class ProductFragment : Fragment(), onClickListener{

    private var _binding: FragmentProductBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProductBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initRecyclerView()

        return root
    }

    //Esta actividad inicia el RecyclerView
    private fun initRecyclerView(){
        binding.rvProducts.layoutManager = LinearLayoutManager(binding.rvProducts.context)
        binding.rvProducts.adapter = ProductAdapter(ProductProvider.getProductList(), this)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickProduct(id : Int) {
        findNavController().navigate(
            ProductFragmentDirections.actionNavProductToNavSelectProduct(id = id)
        )
    }

}