package com.miguelrr.capsshop.ui.selectedproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguelrr.capsshop.CapsShopApp.Companion.idUserSP
import com.miguelrr.capsshop.domain.model.Cap
import com.miguelrr.capsshop.domain.model.ShoppingCar
import com.miguelrr.capsshop.domain.usecases.AddItemSCUseCase
import com.miguelrr.capsshop.domain.usecases.GetCapIdUseCase
import com.miguelrr.capsshop.domain.usecases.VerifyCapAddedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectedProductViewModel @Inject constructor(
    private val getCapIdUseCase: GetCapIdUseCase,
    private val verifyCapAddedUseCase: VerifyCapAddedUseCase,
    private val addItemSCUseCase: AddItemSCUseCase
): ViewModel(){

    private val _cap = MutableLiveData<Cap>()
    val cap : LiveData<Cap> get() = _cap
    private val _verifySP = MutableLiveData<Boolean>()
    val verifySP : LiveData<Boolean> get() = _verifySP
    private val _amount = MutableLiveData<Int>()
    val amount : LiveData<Int>  get() = _amount

    init {
        _amount.postValue(1)
    }

    fun onCreate(idCap : Int){
        viewModelScope.launch {
            _cap.postValue(getCapIdUseCase(idCap))
        }
    }

    fun verify(id : Int){
        viewModelScope.launch {
            _verifySP.postValue(verifyCapAddedUseCase(id))
        }
    }

    fun addItemSC(amount : Int, idCap: Int){
        val item = ShoppingCar(0,idCap = idCap, idUser = idUserSP.getId(), amount = amount)
        viewModelScope.launch {
            addItemSCUseCase(item)
        }
    }

    fun plusItem(){
        if(amount.value != 10){
            _amount.postValue(amount.value?.plus(1) ?: 1)
        }
    }

    fun lessItem(){
        if(amount.value != 1){
            _amount.postValue(amount.value?.minus(1) ?: 1)
        }
    }
}