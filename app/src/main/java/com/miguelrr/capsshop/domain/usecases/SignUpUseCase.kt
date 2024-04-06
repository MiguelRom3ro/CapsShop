package com.miguelrr.capsshop.domain.usecases

import com.miguelrr.capsshop.data.UserRepository
import com.miguelrr.capsshop.domain.model.ResponseSignUp
import com.miguelrr.capsshop.domain.model.SignUpUser
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val userRepository: UserRepository
){

    suspend operator fun invoke(signUpUser: SignUpUser) : ResponseSignUp{
        return userRepository.signUp(signUpUser)
    }
}