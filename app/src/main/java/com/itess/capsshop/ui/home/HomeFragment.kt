package com.itess.capsshop.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.itess.capsshop.adapter.carousell.CarousellAdapter
import com.itess.capsshop.adapter.producthome.ProductHomeAdapter
import com.itess.capsshop.data.provider.CarousellProvider
import com.itess.capsshop.data.provider.ProductProvider
import com.itess.capsshop.databinding.FragmentHomeBinding
import com.itess.capsshop.ui.onClickListener

class HomeFragment : Fragment() , onClickListener{

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initRecyclerViewCarousell()
        initRecyclerViewNBA()
        initRecyclerViewNFL()
        initRecyclerViewMBL()


        return root
    }

    private fun initRecyclerViewCarousell(){
        binding.rvCarousell.layoutManager = LinearLayoutManager(binding.rvCarousell.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCarousell.adapter = CarousellAdapter(CarousellProvider.getImagesList()) // Llamamos a nuestra clase ProductoAdapter.kt
    }

    private fun initRecyclerViewNBA(){
        binding.rvCardsNba.layoutManager = LinearLayoutManager(binding.rvCardsNba.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCardsNba.adapter = ProductHomeAdapter(ProductProvider.getNBAProducts(), this) // Llamamos a nuestra clase ProductoAdapter.kt
    }

    private fun initRecyclerViewNFL(){
        binding.rvCardsNfl.layoutManager = LinearLayoutManager(binding.rvCardsNfl.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCardsNfl.adapter = ProductHomeAdapter(ProductProvider.getNFLProducts(), this) // Llamamos a nuestra clase ProductoAdapter.kt
    }

    private fun initRecyclerViewMBL(){
        binding.rvCardsMbl.layoutManager = LinearLayoutManager(binding.rvCardsMbl.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCardsMbl.adapter = ProductHomeAdapter(ProductProvider.getMBLProducts(), this) // Llamamos a nuestra clase ProductoAdapter.kt
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickProduct(id: Int) {
        findNavController().navigate(
            HomeFragmentDirections.actionNavHomeToNavSelectProduct(id = id)
        )
    }
}