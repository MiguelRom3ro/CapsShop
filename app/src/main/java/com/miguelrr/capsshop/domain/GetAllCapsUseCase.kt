package com.miguelrr.capsshop.domain

import com.miguelrr.capsshop.data.CapRepository
import com.miguelrr.capsshop.data.database.entity.toDatabase
import com.miguelrr.capsshop.domain.model.Cap
import javax.inject.Inject

class GetAllCapsUseCase @Inject constructor(
    private val repository: CapRepository
) {

    suspend operator fun invoke(){
        val caps = repository.getAllCapsFromApi()

        if(caps.isNotEmpty()){
            repository.deleteCaps()
            repository.insertCaps(caps.map { it.toDatabase() })
        }
    }
}