package com.example.composition.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composition.data.OnboardingItem
import com.example.composition.ui.theme.DarkText
import com.example.composition.ui.theme.LightText

/**
 * Représente une page individuelle
 * de l'onboarding.
 */
@Composable
fun OnboardingPage(
    item: OnboardingItem
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 26.dp),

        horizontalAlignment = Alignment.Start
    ) {

        Spacer(modifier = Modifier.height(55.dp))

        // Titre principal
        Text(
            text = item.title,
            color = DarkText,
            fontSize = 31.sp,
            lineHeight = 38.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Description secondaire
        Text(
            text = item.description,
            color = LightText,
            fontSize = 15.sp,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Illustration associée à la page
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,

            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),

            contentScale = ContentScale.Fit
        )
    }
}