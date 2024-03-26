package com.miguelrr.capsshop.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miguelrr.capsshop.data.database.entity.CapEntity

@Dao
interface CapDao {

    @Query("SELECT * FROM cap_table")
    suspend fun getAllCaps() : List<CapEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(caps : List<CapEntity>)

    @Query("DELETE FROM cap_table")
    suspend fun deleteAllQuotes()
}