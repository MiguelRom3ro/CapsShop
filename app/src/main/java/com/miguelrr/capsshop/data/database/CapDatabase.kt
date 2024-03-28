package com.miguelrr.capsshop.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miguelrr.capsshop.data.database.dao.CapDao
import com.miguelrr.capsshop.data.database.dao.ShoppingCarDao
import com.miguelrr.capsshop.data.database.entity.CapEntity
import com.miguelrr.capsshop.data.database.entity.ShoppingCarEntity

@Database(entities = [CapEntity::class, ShoppingCarEntity::class], version = 1)
abstract class CapDatabase : RoomDatabase() {

    abstract fun getCapDao() : CapDao

    abstract fun getShoppingCarDao() : ShoppingCarDao
}