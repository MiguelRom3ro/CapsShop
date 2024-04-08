package com.miguelrr.capsshop.ui.adapter.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguelrr.capsshop.databinding.ViewSearchCardBinding
import com.miguelrr.capsshop.domain.listeners.OnClickSearch
import com.miguelrr.capsshop.domain.model.Cap

class SearchViewHolder (view: View, private val listen : OnClickSearch
) : RecyclerView.ViewHolder(view) {

    val binding = ViewSearchCardBinding.bind(view)

    fun render(cap: Cap) {
        Glide.with(binding.ivScProduct.context)
            .load(cap.image)
            .centerCrop()
            .into(binding.ivScProduct)

        binding.tvScProduct.text = cap.name
        binding.tvScPrice.text = "${cap.price}"

        binding.searchCard.setOnClickListener{
            listen.onClickSearch(cap.id)
        }
    }
}