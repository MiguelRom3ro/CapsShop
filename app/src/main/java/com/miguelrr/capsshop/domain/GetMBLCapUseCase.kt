package com.miguelrr.capsshop.domain

import com.miguelrr.capsshop.data.CapRepository
import com.miguelrr.capsshop.domain.model.Cap
import javax.inject.Inject

class GetMBLCapUseCase @Inject constructor(
    private val repository: CapRepository
) {

    suspend operator fun invoke(): List<Cap> {
        return repository.getMBLCaps()
    }
}