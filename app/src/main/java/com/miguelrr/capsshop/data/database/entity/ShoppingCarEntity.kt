package com.miguelrr.capsshop.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.miguelrr.capsshop.domain.model.ShoppingCar

@Entity(tableName = "shoppingcar_table")
data class ShoppingCarEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "id_user") val idUser : Int,
    @ColumnInfo(name = "id_cap") val idCap : Int,
    @ColumnInfo(name = "amount") val amount : Int
)

fun ShoppingCar.toDatabase() = ShoppingCarEntity(id, idUser, idCap, amount)