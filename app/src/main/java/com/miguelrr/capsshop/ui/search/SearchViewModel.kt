package com.miguelrr.capsshop.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguelrr.capsshop.domain.model.Cap
import com.miguelrr.capsshop.domain.usecases.GetSearchCapUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchCapUseCase: GetSearchCapUseCase
) : ViewModel() {


    private val _searchCaps = MutableLiveData<List<Cap>>()
    val searchCaps : LiveData<List<Cap>> get() = _searchCaps

    fun search(query : String){
        viewModelScope.launch {
            _searchCaps.postValue(getSearchCapUseCase(query))
        }
    }
}