package com.miguelrr.capsshop.ui.adapter.horizontal

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguelrr.capsshop.databinding.ViewHorizontalCardBinding
import com.miguelrr.capsshop.domain.listeners.OnClickHorizontal
import com.miguelrr.capsshop.domain.model.Cap

class HorizontalViewHolder(view: View,
private val listen : OnClickHorizontal) : RecyclerView.ViewHolder(view) {

    val binding = ViewHorizontalCardBinding.bind(view)

    fun render(cap: Cap) {
        binding.tvNameProduct.text = cap.name
        binding.tvPriceProduct.text = "$${cap.price}"
        Glide.with(binding.ivCardHorizontal.context)
            .load(cap.image)
            .centerCrop()
            .into(binding.ivCardHorizontal)

        binding.ivCardHorizontal.setOnClickListener{
            listen.onClickHorizontal(cap.id)
        }
    }
}