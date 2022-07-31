package com.example.pahlawannasional.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.pahlawannasional.data.PahlawanRepository

class MainViewModel(repository: PahlawanRepository) : ViewModel() {
    val pahlawan = repository.pahlawanStream.asLiveData(viewModelScope.coroutineContext)
}