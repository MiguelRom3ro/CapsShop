package com.miguelrr.capsshop.domain.usecases

import com.miguelrr.capsshop.data.UserRepository
import com.miguelrr.capsshop.domain.model.LoginUser
import com.miguelrr.capsshop.domain.model.ResponseSignUp
import com.miguelrr.capsshop.domain.model.User
import javax.inject.Inject

class LogInUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(loginUser: LoginUser) : User{
        return userRepository.logIn(loginUser)
    }
}