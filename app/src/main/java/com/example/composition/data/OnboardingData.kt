package com.example.composition.data

import com.example.composition.R

/**
 * Représente une page de l'onboarding.
 *
 * @property title Titre principal affiché à l'utilisateur
 * @property description Petit texte descriptif
 * @property image Ressource drawable associée à la page
 */
data class OnboardingItem(
    val title: String,
    val description: String,
    val image: Int
)

/**
 * Liste des différentes pages affichées
 * dans le parcours d'onboarding.
 */
val onboardingPages = listOf(

    OnboardingItem(
        title = "Gérez Vos Stocks\nDepuis Votre\nAppareil",
        description = "Classez, modifiez et suivez vos produits en quelques clics, où que vous soyez.",
        image = R.drawable.onboarding1
    ),

    OnboardingItem(
        title = "Soyez Notifiés Au\nBon Moment",
        description = "Recevez des alertes sur les ruptures de stock ou les seuils critiques pour ne jamais être pris au dépourvu.",
        image = R.drawable.onboarding2
    ),

    OnboardingItem(
        title = "Exportez Vos\nDonnées En Un Clic",
        description = "Générez facilement des rapports PDF ou Word pour partager ou archiver vos stocks.",
        image = R.drawable.onboarding3
    ),

    OnboardingItem(
        title = "Faites Des\nÉconomies Et\nGagnez Du Temps",
        description = "Évitez les ruptures, limitez les erreurs, et gérez vos stocks intelligemment pour optimiser chaque dépense.",
        image = R.drawable.onboarding4
    ),

    OnboardingItem(
        title = "Prêts À Gérer Vos\nStocks Facilement ?",
        description = "Profitez d’un outil simple, rapide et intelligent.",
        image = R.drawable.start
    )
)