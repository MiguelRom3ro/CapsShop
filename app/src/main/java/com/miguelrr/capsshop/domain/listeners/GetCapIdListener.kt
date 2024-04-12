package com.miguelrr.capsshop.domain.listeners

import com.miguelrr.capsshop.domain.model.Cap

interface GetCapIdListener {

    suspend fun getCap(id : Int) : Cap
}