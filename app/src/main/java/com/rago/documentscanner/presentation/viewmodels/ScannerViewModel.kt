package com.rago.documentscanner.presentation.viewmodels

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.rago.documentscanner.presentation.uistate.ScannerUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class ScannerViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(ScannerUiState())
    val uiState = _uiState.asStateFlow()

    fun onScanResult(uri: Uri?) {
        _uiState.update { it.copy(scannedImageUri = uri) }
    }
}