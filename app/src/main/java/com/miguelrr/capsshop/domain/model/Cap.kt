package com.miguelrr.capsshop.domain.model

import com.miguelrr.capsshop.data.database.entity.CapEntity
import com.miguelrr.capsshop.data.model.CapModel

data class Cap(
    val id : Int,
    val name : String,
    val category : String,
    val price : Double,
    val description : String,
    val image : String
)

fun CapModel.toDomain() = Cap(id, name, category, price, description, image)
fun CapEntity.toDomain() = Cap(id, name, category, price, description, image)

