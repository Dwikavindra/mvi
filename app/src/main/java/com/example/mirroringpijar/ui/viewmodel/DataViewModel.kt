package com.example.mirroringpijar.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mirroringpijar.data.repository.MainRepository
import com.example.mirroringpijar.ui.viewstate.DataState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class DataViewModel(
    private val repository: MainRepository
) : ViewModel() {

    val dataIntent = Channel<DataIntent>(Channel.UNLIMITED)
    val dataState = MutableStateFlow<DataState>(DataState.Inactive)


    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            dataIntent.consumeAsFlow().collect {
                when (it) {
                    is DataIntent.FetchData -> fetchData()
                }
            }
        }
    }

    private fun fetchData() {
        viewModelScope.launch {
            dataState.value = DataState.Loading
            dataState.value = try {
                DataState.ResponseData(repository.getUsers())
            } catch (e: Exception) {
                DataState.Error(e.localizedMessage)
            }
        }
    }
}