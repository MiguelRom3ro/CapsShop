package com.miguelrr.capsshop.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguelrr.capsshop.domain.model.LoginUser
import com.miguelrr.capsshop.domain.model.User
import com.miguelrr.capsshop.domain.usecases.LogInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val logInUseCase: LogInUseCase
): ViewModel() {

    private val _user = MutableLiveData<User>()
    val user : LiveData<User> get() = _user

    fun logIn(loginUser: LoginUser){
        viewModelScope.launch {
            _user.postValue(logInUseCase(loginUser))
        }
    }
}