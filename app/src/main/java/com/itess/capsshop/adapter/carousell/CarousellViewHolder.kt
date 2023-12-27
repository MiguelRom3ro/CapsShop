package com.itess.capsshop.adapter.carousell

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itess.capsshop.databinding.ViewCarousellBinding

// ViewHolder que representa un elemento individual dentro del RecyclerView
class CarousellViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // Referencias a las vistas dentro del elemento de producto
    val binding = ViewCarousellBinding.bind(view)

    // Función para actualizar las vistas con datos específicos de un Producto
    fun render(img: String) {
        // Asignar datos del modelo a las vistas correspondientes

        // Cargar la imagen usando Glide (o tu biblioteca de carga de imágenes preferida)
        Glide.with(binding.ivCarousel.context).load(img).into(binding.ivCarousel)

    }
}