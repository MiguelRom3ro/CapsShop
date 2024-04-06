package com.miguelrr.capsshop.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguelrr.capsshop.CapsShopApp.Companion.idUserSP
import com.miguelrr.capsshop.domain.IdUserSharedPreferences
import com.miguelrr.capsshop.domain.model.User
import com.miguelrr.capsshop.domain.usecases.GetUserByIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountViewModel @Inject constructor(
    private val getUserById : GetUserByIdUseCase
): ViewModel()  {

    private val _idUser = MutableLiveData<Int>()
    val idUser : LiveData<Int> get() = _idUser
    private val _user = MutableLiveData<User>()
    val user : LiveData<User> get() = _user

    fun onCreate(){
        _idUser.postValue(idUserSP.getId())
    }

    fun getUser(id : Int){
        viewModelScope.launch {
            _user.postValue(getUserById(id))
        }
    }
}