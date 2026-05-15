package com.example.stocknow.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.stocknow.data.models.UserSettings

class SettingsViewModel : ViewModel() {
    // État des paramètres
    var settings = mutableStateOf(UserSettings())

    init {
        chargerParametres()
    }

    private fun chargerParametres() {
        // Simulation des réglages actuels
        settings.value = UserSettings(
            notificationsActivees = true,
            langue = "Français",
            modeSombre = false
        )
    }

    fun toggleNotifications(enabled: Boolean) {
        settings.value = settings.value.copy(notificationsActivees = enabled)
        // TODO: Sauvegarder dans Firebase après le merge
    }
}