package com.itess.capsshop.adapter.product

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itess.capsshop.data.Product
import com.itess.capsshop.data.provider.ShoppingCarProvider
import com.itess.capsshop.databinding.ViewVerticalProductBinding
import com.itess.capsshop.ui.onClickListener

// ViewHolder que representa un elemento individual dentro del RecyclerView
class ProductViewHolder(view: View, private val listen : onClickListener) : RecyclerView.ViewHolder(view) {

    // Referencias a las vistas dentro del elemento de producto
    val binding = ViewVerticalProductBinding.bind(view)

    // Función para actualizar las vistas con datos específicos de un Producto
    fun render(productModel: Product) {

        binding.tvNameProductVertical.text = productModel.name
        "$${productModel.price}".also { binding.tvPriceProductVertical.text = it }
        Glide.with(binding.ivProducto.context).load(productModel.img).into(binding.ivProducto)

        binding.cardViewVertical.setOnClickListener{
            setListener(productModel.id)
        }

        binding.btnAddScVertical.setOnClickListener{
            ShoppingCarProvider.addProduct(productModel.id, 1)
            Toast.makeText(binding.ivProducto.context, "Agregado con exito", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setListener(id: Int){
        listen.onClickProduct(id)
    }
}