package com.miguelrr.capsshop.domain.model

import com.miguelrr.capsshop.data.database.entity.ShoppingCarEntity

data class ShoppingCar (
    val id : Int,
    val idCap : Int,
    val idUser : Int,
    var amount : Int
) {
}

fun ShoppingCarEntity.toDomain() = ShoppingCar(id, idCap, idUser, amount)

