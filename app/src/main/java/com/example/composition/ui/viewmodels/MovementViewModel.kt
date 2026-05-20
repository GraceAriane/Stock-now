package com.example.composition.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composition.data.models.Movement

class MovementViewModel : ViewModel() {
    // États pour les champs du formulaire
    var nomProduit = mutableStateOf("")
    var quantite = mutableStateOf("")
    var typeSelectionne = mutableStateOf("Entrée")
    var dateSelectionnee = mutableStateOf("24 avr. 2024")

    // État pour savoir si l'enregistrement est en cours ou réussi
    var isSaving = mutableStateOf(false)
    var statusMessage = mutableStateOf("")

    fun enregistrer() {
        if (nomProduit.value.isEmpty()) {
            statusMessage.value = "Le nom du produit est requis"
            return
        }

        isSaving.value = true

        // Ici, on prépare l'objet à envoyer
        val nouveauMouvement = Movement(
            produitNom = nomProduit.value,
            quantite = quantite.value.toIntOrNull() ?: 0,
            type = typeSelectionne.value,
            date = System.currentTimeMillis() // On utilise un vrai timestamp
        )

        // Simule un succès
        statusMessage.value = "Enregistrement réussi !"
        isSaving.value = false
    }
}
