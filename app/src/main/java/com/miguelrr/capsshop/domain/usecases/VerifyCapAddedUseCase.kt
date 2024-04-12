package com.miguelrr.capsshop.domain.usecases

import com.miguelrr.capsshop.CapsShopApp.Companion.idUserSP
import com.miguelrr.capsshop.data.ShoppingCarRepository
import javax.inject.Inject

class VerifyCapAddedUseCase @Inject constructor(
    private val shoppingCarRepository: ShoppingCarRepository
) {

    suspend operator fun invoke(idCap : Int) : Boolean{
        val idUser = idUserSP.getId()
        return shoppingCarRepository.verifyCapAdded(idCap, idUser)
    }
}