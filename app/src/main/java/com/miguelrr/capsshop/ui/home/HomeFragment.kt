package com.miguelrr.capsshop.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelrr.capsshop.databinding.FragmentHomeBinding
import com.miguelrr.capsshop.ui.adapter.carousel.CarouselAdapter
import com.miguelrr.capsshop.ui.adapter.horizontal.HorizontalAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val homeViewModel : HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        Log.d("Pruebas", "OnCreateView..............................")
        homeViewModel.onCreate()

        homeViewModel.images.observe(viewLifecycleOwner){
            binding.rvHomeCarousel.layoutManager = LinearLayoutManager(binding.rvHomeCarousel.context, LinearLayoutManager.HORIZONTAL, false)
            binding.rvHomeCarousel.adapter = CarouselAdapter(it)
        }

        homeViewModel.nbaCaps.observe(viewLifecycleOwner){
            binding.rvHomeNba.layoutManager = LinearLayoutManager(binding.rvHomeNba.context, LinearLayoutManager.HORIZONTAL, false)
            binding.rvHomeNba.adapter = HorizontalAdapter(it)
        }

        homeViewModel.nflCaps.observe(viewLifecycleOwner){
            binding.rvHomeNfl.layoutManager = LinearLayoutManager(binding.rvHomeNfl.context, LinearLayoutManager.HORIZONTAL, false)
            binding.rvHomeNfl.adapter = HorizontalAdapter(it)
        }

        homeViewModel.mblCaps.observe(viewLifecycleOwner){
            binding.rvHomeMbl.layoutManager = LinearLayoutManager(binding.rvHomeMbl.context, LinearLayoutManager.HORIZONTAL, false)
            binding.rvHomeMbl.adapter = HorizontalAdapter(it)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}