package com.miguelrr.capsshop.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miguelrr.capsshop.data.database.dao.CapDao
import com.miguelrr.capsshop.data.database.entity.CapEntity

@Database(entities = [CapEntity::class], version = 1)
abstract class CapDatabase : RoomDatabase() {

    abstract fun getCapDao() : CapDao
}