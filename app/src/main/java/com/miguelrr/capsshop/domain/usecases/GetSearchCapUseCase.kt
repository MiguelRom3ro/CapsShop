package com.miguelrr.capsshop.domain.usecases

import com.miguelrr.capsshop.data.CapRepository
import com.miguelrr.capsshop.data.database.entity.toDatabase
import com.miguelrr.capsshop.domain.model.Cap
import javax.inject.Inject

class GetSearchCapUseCase @Inject constructor(
    private val capApi : CapRepository
) {

    suspend operator fun invoke(query : String) : List<Cap>{
        return capApi.getSearchCaps(query)
    }
}