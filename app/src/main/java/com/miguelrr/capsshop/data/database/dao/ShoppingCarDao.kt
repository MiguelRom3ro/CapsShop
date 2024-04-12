package com.miguelrr.capsshop.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miguelrr.capsshop.data.database.entity.ShoppingCarEntity

@Dao
interface ShoppingCarDao {

    @Query("SELECT * FROM shoppingcar_table WHERE id_user LIKE :idUser")
    suspend fun getAllItems(idUser : Int) : List<ShoppingCarEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(shoppingCarItem : ShoppingCarEntity)

    @Query("DELETE FROM shoppingcar_table WHERE id LIKE :id AND id_user LIKE :idUser")
    suspend fun deleteItemById(id : Int, idUser: Int)

    @Query("UPDATE shoppingcar_table SET amount = :amount WHERE id LIKE :id AND id_user LIKE :idUser")
    suspend fun updateAmountItem(amount : Int, id : Int, idUser: Int)

    @Query("SELECT EXISTS( SELECT 1 FROM shoppingcar_table WHERE id_cap LIKE :idCap AND id_user LIKE :idUser)")
    suspend fun verifyIfCapAdded(idCap : Int, idUser : Int) : Boolean
}