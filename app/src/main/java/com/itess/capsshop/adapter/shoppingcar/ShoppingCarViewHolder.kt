package com.itess.capsshop.adapter.shoppingcar

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itess.capsshop.data.ShoppingCar
import com.itess.capsshop.data.provider.ShoppingCarProvider
import com.itess.capsshop.databinding.ViewShoppingcarProductBinding
import com.itess.capsshop.ui.onClickUpdate

// ViewHolder que representa un elemento individual dentro del RecyclerView
class ShoppingCarViewHolder(view: View
, private val listener : onClickUpdate) : RecyclerView.ViewHolder(view) {

    // Referencias a las vistas dentro del elemento de producto
    val binding = ViewShoppingcarProductBinding.bind(view)

    // Función para actualizar las vistas con datos específicos de un Producto
    fun render(productModel: ShoppingCar) {
        // Asignar datos del modelo a las vistas correspondientes
        binding.tvShoppingcarName.text = productModel.name
        binding.tvCantidadSc.text = productModel.amount.toString()
        "$${productModel.price}".also { binding.tvPriceSc.text = it }

        // Cargar la imagen usando Glide (o tu biblioteca de carga de imágenes preferida)
        Glide.with(binding.ivShoppingcar.context).load(productModel.img).into(binding.ivShoppingcar)

        binding.tvDelete.setOnClickListener{
            ShoppingCarProvider.deleteProduct(productModel)
            Toast.makeText(binding.ivShoppingcar.context, "Eliminado con exito", Toast.LENGTH_SHORT).show()
            bindingAdapter?.notifyDataSetChanged()
            updateTotal()
        }

        binding.plusSc.setOnClickListener{
            if(!ShoppingCarProvider.plusAmount(productModel)){
                Toast.makeText(binding.ivShoppingcar.context, "Limite alcanzado", Toast.LENGTH_SHORT).show()
            }
            bindingAdapter?.notifyDataSetChanged()
            updateTotal()
        }

        binding.substractSc.setOnClickListener{
            if(!ShoppingCarProvider.substractAmount(productModel)){
                Toast.makeText(binding.ivShoppingcar.context, "Opcion invalida", Toast.LENGTH_SHORT).show()
            }
            bindingAdapter?.notifyDataSetChanged()
            updateTotal()
        }
    }

    private fun updateTotal(){
        listener.update()
    }
}