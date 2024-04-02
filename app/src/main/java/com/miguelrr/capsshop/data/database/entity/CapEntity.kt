package com.miguelrr.capsshop.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.miguelrr.capsshop.domain.model.Cap

@Entity(tableName = "cap_table")
data class CapEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "category") val category : String,
    @ColumnInfo(name = "price") val price : Double,
    @ColumnInfo(name = "description") val description : String,
    @ColumnInfo(name = "image") val image : String
)

fun Cap.toDatabase() = CapEntity(id, name, category, price, description, image)
