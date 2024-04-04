package com.miguelrr.capsshop.ui.selectedproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguelrr.capsshop.domain.model.Cap
import com.miguelrr.capsshop.domain.usecases.GetCapIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectedProductViewModel @Inject constructor(
    private val getCapIdUseCase: GetCapIdUseCase
): ViewModel(){

    private var _cap = MutableLiveData<Cap>()
    val cap : LiveData<Cap> get() = _cap

    fun onCreate(idCap : Int){
        viewModelScope.launch {
            _cap.postValue(getCapIdUseCase(idCap))
        }
    }
}