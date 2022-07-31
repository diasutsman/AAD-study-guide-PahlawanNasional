package com.example.pahlawannasional.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pahlawannasional.data.PahlawanRepository
import com.example.pahlawannasional.data.responses.Pahlawan

private const val ITEMS_PER_PAGE = 50

class MainViewModel(repository: PahlawanRepository) : ViewModel() {
    //    val pahlawan = repository.pahlawanStream.asLiveData(viewModelScope.coroutineContext)
    val pahlawan: LiveData<PagingData<Pahlawan>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { repository.pahlawanPagingSource() }
    )
        .flow
        .asLiveData(viewModelScope.coroutineContext)
}
