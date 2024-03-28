package com.miguelrr.capsshop.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miguelrr.capsshop.data.database.entity.ShoppingCarEntity

@Dao
interface ShoppingCarDao {

    @Query("SELECT * FROM shoppingcar_table")
    suspend fun getAllItems() : List<ShoppingCarEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(shoppingCarItem : ShoppingCarEntity)

    @Query("DELETE FROM shoppingcar_table WHERE id LIKE :id")
    suspend fun deleteItemById(id : Int)

    @Query("UPDATE shoppingcar_table SET amount = :amount WHERE id LIKE :id")
    suspend fun updateAmountItem(amount : Int, id : Int)
}