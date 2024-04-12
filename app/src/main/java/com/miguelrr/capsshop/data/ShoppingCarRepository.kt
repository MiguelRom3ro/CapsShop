package com.miguelrr.capsshop.data

import com.miguelrr.capsshop.data.database.dao.ShoppingCarDao
import com.miguelrr.capsshop.data.database.entity.ShoppingCarEntity
import com.miguelrr.capsshop.domain.model.ShoppingCar
import com.miguelrr.capsshop.domain.model.toDomain
import javax.inject.Inject

class ShoppingCarRepository @Inject constructor(
    private val shoppingCarDao: ShoppingCarDao
) {

    suspend fun insertItem(shoppingCar: ShoppingCarEntity){
        shoppingCarDao.insertItem(shoppingCar)
    }

    suspend fun getAllItems(idUser : Int) : List<ShoppingCar>{
        return shoppingCarDao.getAllItems(idUser).map { it.toDomain() }
    }

    suspend fun deleteItem(id : Int, idUser : Int){
        shoppingCarDao.deleteItemById(id, idUser)
    }

    suspend fun updateAmount(amount : Int, id : Int, idUser : Int){
        shoppingCarDao.updateAmountItem(amount, id, idUser)
    }

    suspend fun verifyCapAdded(idCap : Int, idUser : Int) : Boolean{
        return shoppingCarDao.verifyIfCapAdded(idCap, idUser)
    }
}