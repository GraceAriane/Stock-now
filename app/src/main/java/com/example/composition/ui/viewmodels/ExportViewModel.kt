package com.example.stocknow.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ExportViewModel : ViewModel() {
    var isExporting = mutableStateOf(false)
    var exportProgress = mutableStateOf(0f)
    var exportStatus = mutableStateOf("")

    fun genererExport(format: String) {
        viewModelScope.launch {
            isExporting.value = true
            exportStatus.value = "Génération du $format en cours..."

            // Simulation de progression
            for (i in 1..10) {
                delay(300)
                exportProgress.value = i / 10f
            }

            isExporting.value = false
            exportStatus.value = "Le fichier $format a été enregistré dans vos documents."
        }
    }
}