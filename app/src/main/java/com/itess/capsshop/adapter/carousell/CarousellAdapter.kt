package com.itess.capsshop.adapter.carousell

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itess.capsshop.R

// Adaptador para el RecyclerView que muestra una lista de productos
class CarousellAdapter(private val images: List<String>) : RecyclerView.Adapter<CarousellViewHolder>() {

    // Función llamada cuando el RecyclerView necesita crear un nuevo ViewHolder para mostrar un elemento
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarousellViewHolder {
        // Inflar el diseño del elemento de producto desde XML usando un LayoutInflater
        val layoutInflater = LayoutInflater.from(parent.context)
        // Devolver un nuevo ProductoViewHolder que contiene la vista inflada
        return CarousellViewHolder(layoutInflater.inflate(R.layout.view_carousell, parent, false))
    }

    // Función que devuelve la cantidad total de elementos en el conjunto de datos
    override fun getItemCount(): Int = images.size

    // Función llamada por RecyclerView para mostrar los datos en una posición específica
    override fun onBindViewHolder(holder: CarousellViewHolder, position: Int) {
        // Obtener el producto en la posición específica
        val item = images[position]
        // Llamar a la función render de ProductoViewHolder para mostrar los datos en la vista
        holder.render(item)
    }
}