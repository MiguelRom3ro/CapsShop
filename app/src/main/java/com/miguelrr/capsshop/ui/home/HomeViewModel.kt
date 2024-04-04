package com.miguelrr.capsshop.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguelrr.capsshop.domain.usecases.GetAllCapsUseCase
import com.miguelrr.capsshop.domain.usecases.GetAllImagesUseCase
import com.miguelrr.capsshop.domain.usecases.GetMBLCapUseCase
import com.miguelrr.capsshop.domain.usecases.GetNBACapUseCase
import com.miguelrr.capsshop.domain.usecases.GetNFLCapUseCase
import com.miguelrr.capsshop.domain.model.Cap
import com.miguelrr.capsshop.domain.model.Image
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCaps : GetAllCapsUseCase,
    private val getNBACaps : GetNBACapUseCase,
    private val getNFLCaps : GetNFLCapUseCase,
    private val getMBLCaps : GetMBLCapUseCase,
    private val getImages : GetAllImagesUseCase
): ViewModel() {

    private var _images = MutableLiveData<List<Image>>()
    val images : LiveData<List<Image>> get() = _images
    private var _nbaCaps = MutableLiveData<List<Cap>>()
    val nbaCaps : LiveData<List<Cap>> get() = _nbaCaps
    private var _nflCaps = MutableLiveData<List<Cap>>()
    val nflCaps : LiveData<List<Cap>> get() = _nflCaps
    private var _mblCaps = MutableLiveData<List<Cap>>()
    val mblCaps : LiveData<List<Cap>> get() = _mblCaps

    fun onCreate(){
        Log.d("Pruebas", "OnCreate..............................")
        viewModelScope.launch {
            Log.d("Pruebas", "BeforeGetAllCaps..............................")
            getAllCaps()
            Log.d("Pruebas", "GetAllCaps..............................")

            _images.postValue(getImages())
            _nbaCaps.postValue(getNBACaps())
            _nflCaps.postValue(getNFLCaps())
            _mblCaps.postValue(getMBLCaps())
        }
    }

}