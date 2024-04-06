package com.miguelrr.capsshop.domain.usecases

import com.miguelrr.capsshop.data.UserRepository
import com.miguelrr.capsshop.domain.model.User
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val userRepository: UserRepository
){

    suspend operator fun invoke(idUser : Int) : User{
        return userRepository.searchById(idUser)
    }
}