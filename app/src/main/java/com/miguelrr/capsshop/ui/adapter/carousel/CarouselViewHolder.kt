package com.miguelrr.capsshop.ui.adapter.carousel

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguelrr.capsshop.databinding.ViewCarouselBinding
import com.miguelrr.capsshop.domain.model.Image

// ViewHolder que representa un elemento individual dentro del RecyclerView
class CarouselViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ViewCarouselBinding.bind(view)

    fun render(img: Image) {
        Glide.with(binding.ivCarousel.context)
            .load(img.image)
            .centerCrop()
            .into(binding.ivCarousel)
    }
}
