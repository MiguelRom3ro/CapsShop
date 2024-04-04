package com.miguelrr.capsshop.domain.usecases

import com.miguelrr.capsshop.data.CapRepository
import com.miguelrr.capsshop.data.database.entity.toDatabase
import com.miguelrr.capsshop.domain.model.Cap
import javax.inject.Inject

class GetCapIdUseCase @Inject constructor(
    private val capRepository: CapRepository
){

    suspend operator fun invoke(id : Int) : Cap{
        return capRepository.getCapByID(id)
    }

}