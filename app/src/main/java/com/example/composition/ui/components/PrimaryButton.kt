package com.example.composition.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.graphics.Color
import com.example.composition.ui.theme.PrimaryGreen

/**
 * Bouton principal réutilisable de l'application.
 *
 * Utilisé dans les écrans principaux comme
 * l'onboarding pour garder un style uniforme.
 *
 * @param text Texte affiché dans le bouton
 * @param onClick Action exécutée lors du clic
 */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,

        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),

        // Arrondit les coins du bouton
        shape = RoundedCornerShape(12.dp),

        // Couleur principale de l'application
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryGreen
        )

    ) {

        // Texte affiché dans le bouton
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}