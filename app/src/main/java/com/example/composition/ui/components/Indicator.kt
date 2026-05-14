package com.example.composition.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.composition.ui.theme.IndicatorInactive
import com.example.composition.ui.theme.PrimaryGreen

/**
 * Affiche les indicateurs de pagination
 * de l'onboarding.
 *
 * Le point actif change de couleur et de taille.
 */
@Composable
fun Indicator(
    currentPage: Int,
    totalPages: Int
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        repeat(totalPages) { index ->

            Box(
                modifier = Modifier
                    .size(
                        if (index == currentPage) 10.dp else 8.dp
                    )
                    .clip(CircleShape)
                    .background(
                        if (index == currentPage)
                            PrimaryGreen
                        else
                            IndicatorInactive
                    )
            )
        }
    }
}