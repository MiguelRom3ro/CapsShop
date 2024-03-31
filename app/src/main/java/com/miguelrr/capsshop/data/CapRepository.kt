package com.miguelrr.capsshop.data

import com.miguelrr.capsshop.data.database.dao.CapDao
import com.miguelrr.capsshop.data.database.entity.CapEntity
import com.miguelrr.capsshop.data.network.NetworkService
import com.miguelrr.capsshop.domain.model.Cap
import com.miguelrr.capsshop.domain.model.toDomain
import javax.inject.Inject

class CapRepository @Inject constructor(
    private val api : NetworkService,
    private val capDao : CapDao
) {


    suspend fun getAllCapsFromApi() : List<Cap>{
        val response = api.getCaps()
        return response.map { it.toDomain() }
    }

    suspend fun getNBACaps() : List<Cap>{
        val response : List<CapEntity> = capDao.getNBACaps()
        return response.map { it.toDomain() }
    }

    suspend fun getNFLCaps() : List<Cap>{
        val response : List<CapEntity> = capDao.getNFLCaps()
        return response.map { it.toDomain() }
    }

    suspend fun getMBLCaps() : List<Cap>{
        val response : List<CapEntity> = capDao.getMBLCaps()
        return response.map { it.toDomain() }
    }

    suspend fun getCapByID(id : Int) : Cap {
        val response : CapEntity = capDao.getCapById(id)
        return response.toDomain()
    }

    suspend fun getSearchCaps(search : String) : List<Cap>{
        val response : List<CapEntity> = capDao.getSearchCaps(search)
        return response.map { it.toDomain() }
    }

    suspend fun insertCaps(caps : List<CapEntity>){
        capDao.insertAll(caps)
    }

    suspend fun deleteCaps() {
        capDao.deleteAllCaps()
    }
}