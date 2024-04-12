package com.miguelrr.capsshop.domain.usecases

import com.miguelrr.capsshop.CapsShopApp.Companion.idUserSP
import com.miguelrr.capsshop.data.ShoppingCarRepository
import com.miguelrr.capsshop.domain.model.ShoppingCar
import javax.inject.Inject

class GetAllItemsSCUseCase @Inject constructor(
    private val shoppingCarRepository: ShoppingCarRepository
) {

    suspend operator fun invoke() : List<ShoppingCar>{
        val idUser = idUserSP.getId()
        return shoppingCarRepository.getAllItems(idUser)
    }
}