package com.example.composition.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composition.data.onboardingPages
import com.example.composition.ui.components.Indicator
import com.example.composition.ui.components.OnboardingPage
import com.example.composition.ui.components.PrimaryButton
import kotlinx.coroutines.launch

/**
 * Écran principal de l'onboarding.
 *
 * Permet à l'utilisateur de parcourir
 * les différentes pages de présentation.
 */
@Composable
fun OnboardingScreen(
    navController: NavController
) {

    // État du pager horizontal
    val pagerState = rememberPagerState(
        pageCount = {
            onboardingPages.size
        }
    )

    // Scope utilisé pour les animations de scroll
    val coroutineScope = rememberCoroutineScope()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF5F3F3)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            // Pager horizontal des pages onboarding
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->

                OnboardingPage(
                    item = onboardingPages[page]
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 26.dp,
                        vertical = 20.dp
                    ),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Indicateur de pagination
                Indicator(
                    currentPage = pagerState.currentPage,
                    totalPages = onboardingPages.size
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Bouton principal de navigation
                PrimaryButton(

                    text =
                        if (
                            pagerState.currentPage ==
                            onboardingPages.lastIndex
                        )
                            "Commencer"
                        else
                            "Suivant",

                    onClick = {

                        coroutineScope.launch {

                            // Passe à la page suivante
                            if (
                                pagerState.currentPage <
                                onboardingPages.lastIndex
                            ) {

                                pagerState.animateScrollToPage(
                                    pagerState.currentPage + 1
                                )

                            } else {

                                // Redirection vers l'écran principal
                                navController.navigate("login")
                            }
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    val navController = rememberNavController()
    OnboardingScreen(navController = navController)
}
