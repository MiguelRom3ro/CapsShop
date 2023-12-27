package com.itess.capsshop.adapter.producthome

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itess.capsshop.data.Product
import com.itess.capsshop.data.ShoppingCar
import com.itess.capsshop.data.provider.ShoppingCarProvider
import com.itess.capsshop.databinding.ViewHorizontalProductBinding
import com.itess.capsshop.ui.onClickListener

// ViewHolder que representa un elemento individual dentro del RecyclerView
class ProductHomeViewHolder(view: View, private val listen : onClickListener) : RecyclerView.ViewHolder(view) {

    // Referencias a las vistas dentro del elemento de producto
    val binding = ViewHorizontalProductBinding.bind(view)

    // Función para actualizar las vistas con datos específicos de un Producto
    fun render(productModel: Product) {
        // Asignar datos del modelo a las vistas correspondientes
        binding.tvNameProduct.text = productModel.name
        "$${productModel.price}".also { binding.tvPriceProduct.text = it }
        // Cargar la imagen usando Glide (o tu biblioteca de carga de imágenes preferida)
        Glide.with(binding.ivCardHorizontal.context).load(productModel.img).into(binding.ivCardHorizontal)

        // Configurar un OnClickListener para la tarjeta (CardView) que muestra un Toast con el nombre del producto
        binding.cardHorizontal.setOnClickListener {
            setListener(productModel.id)
        }

        binding.btnShoppingCarH.setOnClickListener{
            ShoppingCarProvider.addProduct(productModel.id, 1)
            Toast.makeText(binding.ivCardHorizontal.context, "Agregado con exito", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setListener(id: Int){
        listen.onClickProduct(id)
    }
}