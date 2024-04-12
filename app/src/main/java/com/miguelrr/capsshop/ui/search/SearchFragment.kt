package com.miguelrr.capsshop.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelrr.capsshop.databinding.FragmentSearchBinding
import com.miguelrr.capsshop.domain.listeners.OnClickSearch
import com.miguelrr.capsshop.ui.adapter.search.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(), OnClickSearch {
    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val searchViewModel : SearchViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchViewModel.search(query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //searchViewModel.search(newText ?: "")
                return true
            }
        })

        searchViewModel.searchCaps.observe(viewLifecycleOwner){
            Toast.makeText(context, "${it.size}", Toast.LENGTH_SHORT).show()
            binding.rvSearch.layoutManager = LinearLayoutManager(binding.rvSearch.context, LinearLayoutManager.VERTICAL, false)
            binding.rvSearch.adapter = SearchAdapter(it, this)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickSearch(id: Int) {
        findNavController().navigate(SearchFragmentDirections.actionNavigationSearchToNavigationSelectedProduct(idCap = id))
    }
}