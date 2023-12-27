package com.itess.capsshop.adapter.shoppingcar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itess.capsshop.R
import com.itess.capsshop.data.ShoppingCar
import com.itess.capsshop.ui.onClickUpdate

// Adaptador para el RecyclerView que muestra una lista de productos
class ShoppingCarAdapter(
    private val productsSC: List<ShoppingCar>,
    private val listener : onClickUpdate
    ) : RecyclerView.Adapter<ShoppingCarViewHolder>() {

    // Función llamada cuando el RecyclerView necesita crear un nuevo ViewHolder para mostrar un elemento
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCarViewHolder {
        // Inflar el diseño del elemento de producto desde XML usando un LayoutInflater
        val layoutInflater = LayoutInflater.from(parent.context)
        // Devolver un nuevo ProductoViewHolder que contiene la vista inflada
        return ShoppingCarViewHolder(layoutInflater.inflate(R.layout.view_shoppingcar_product, parent, false), listener)
    }

    // Función que devuelve la cantidad total de elementos en el conjunto de datos
    override fun getItemCount(): Int = productsSC.size

    // Función llamada por RecyclerView para mostrar los datos en una posición específica
    override fun onBindViewHolder(holder: ShoppingCarViewHolder, position: Int) {
        // Obtener el producto en la posición específica
        val item = productsSC[position]
        // Llamar a la función render de ProductoViewHolder para mostrar los datos en la vista
        holder.render(item)
    }

}