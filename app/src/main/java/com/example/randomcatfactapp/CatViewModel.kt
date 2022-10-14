package com.example.randomcatfactapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomcatfactapp.data.MeowFacts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(val mainRepository: MainRepository): ViewModel(){
    val catLiveData = MutableLiveData<MeowFacts>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchFacts(){
        viewModelScope.launch {
            val response = mainRepository.getCatFacts()
            if (response.isSuccessful){
                catLiveData.postValue(response.body())
            } else {
                errorLiveData.postValue(response.errorBody().toString())
            }
        }
    }
}