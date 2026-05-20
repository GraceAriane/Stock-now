package com.example.composition.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composition.data.models.UserSettings

class SettingsViewModel : ViewModel() {
    // État des paramètres
    var settings = mutableStateOf(UserSettings())

    init {
        chargerParametres()
    }

    private fun chargerParametres() {
        // Simulation des réglages actuels
        settings.value = UserSettings(
            notificationsEnabled = true,
            language = "Français",
            theme = "Clair"
        )
    }

    fun toggleNotifications(enabled: Boolean) {
        settings.value = settings.value.copy(notificationsEnabled = enabled)
    }
}
