package com.miguelrr.capsshop.domain.usecases

import com.miguelrr.capsshop.data.ShoppingCarRepository
import com.miguelrr.capsshop.data.database.entity.toDatabase
import com.miguelrr.capsshop.domain.model.ShoppingCar
import javax.inject.Inject

class AddItemSCUseCase @Inject constructor(
    private val shoppingCarRepository: ShoppingCarRepository
) {

    suspend operator fun invoke(shoppingCar : ShoppingCar){
        shoppingCarRepository.insertItem(shoppingCar.toDatabase())
    }

}