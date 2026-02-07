package com.example.marsphotos.marsphotos.ui.screens

import com.example.marsphotos.marsphotos.model.MarsPhoto

sealed interface MarsUiState {
    //data class Success(val photos: String) : MarsUiState
    data class Success(val photos: List<MarsPhoto>) : MarsUiState
    object Error : MarsUiState
    object Loading : MarsUiState
}
