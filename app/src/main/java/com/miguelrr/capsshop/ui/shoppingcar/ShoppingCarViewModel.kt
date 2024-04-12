package com.miguelrr.capsshop.ui.shoppingcar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguelrr.capsshop.CapsShopApp.Companion.idUserSP
import com.miguelrr.capsshop.domain.listeners.GetCapIdListener
import com.miguelrr.capsshop.domain.model.Cap
import com.miguelrr.capsshop.domain.model.ShoppingCar
import com.miguelrr.capsshop.domain.usecases.GetAllItemsSCUseCase
import com.miguelrr.capsshop.domain.usecases.GetCapIdUseCase
import com.miguelrr.capsshop.domain.usecases.RemoveItemSCUseCase
import com.miguelrr.capsshop.domain.usecases.UpdateItemSCUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingCarViewModel @Inject constructor(
    private val getAllItemsSCUseCase: GetAllItemsSCUseCase,
    private val updateItemSCUseCase: UpdateItemSCUseCase,
    private val removeItemSCUseCase: RemoveItemSCUseCase,
    private val getCapIdUseCase: GetCapIdUseCase
) : ViewModel(), GetCapIdListener {

    private val _idUser = MutableLiveData<Int>()
    val idUser : LiveData<Int> get() = _idUser
    private val _items = MutableLiveData<List<ShoppingCar>>()
    val items : LiveData<List<ShoppingCar>> get() = _items

    fun onCreate(){
        _idUser.postValue(idUserSP.getId())
    }

    fun getItems(){
        viewModelScope.launch {
            _items.postValue(getAllItemsSCUseCase())
        }
    }

    fun update(amount : Int, id : Int){
        viewModelScope.launch {
            updateItemSCUseCase(amount, id)
            _items.postValue(getAllItemsSCUseCase())
        }
    }

    fun remove(id : Int){
        viewModelScope.launch{
            removeItemSCUseCase(id)
            _items.postValue(getAllItemsSCUseCase())
        }
    }

    override suspend fun getCap(id: Int): Cap {
        return getCapIdUseCase(id)
    }
}