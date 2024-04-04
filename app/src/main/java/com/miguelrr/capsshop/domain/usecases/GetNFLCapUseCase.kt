package com.miguelrr.capsshop.domain.usecases

import com.miguelrr.capsshop.data.CapRepository
import com.miguelrr.capsshop.data.database.entity.toDatabase
import com.miguelrr.capsshop.domain.model.Cap
import javax.inject.Inject

class GetNFLCapUseCase @Inject constructor(
    private val repository: CapRepository
) {

    suspend operator fun invoke() : List<Cap>{
        return repository.getNFLCaps()
    }
}