package com.miguelrr.capsshop.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguelrr.capsshop.domain.model.ResponseSignUp
import com.miguelrr.capsshop.domain.model.SignUpUser
import com.miguelrr.capsshop.domain.usecases.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
): ViewModel() {

    private val _responseSignUp = MutableLiveData<ResponseSignUp>()
    val responseSignUp : LiveData<ResponseSignUp> get() = _responseSignUp

    fun signUp(signUpUser: SignUpUser){
        viewModelScope.launch {
            _responseSignUp.postValue(signUpUseCase(signUpUser))
        }
    }
}