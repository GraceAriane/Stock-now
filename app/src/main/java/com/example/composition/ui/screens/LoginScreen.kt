package com.example.composition.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composition.ui.components.*
import com.example.composition.ui.theme.BackgroundGray
import com.example.composition.ui.theme.PrimaryGreen

@Composable
fun LoginScreen(
    navController: NavController
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var emailError by remember {
        mutableStateOf(false)
    }

    var passwordError by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGray)
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.height(80.dp))

        AuthHeader(
            title = "Connexion",
            subtitle = "Connectez-vous pour gérer vos stocks facilement."
        )

        Spacer(modifier = Modifier.height(40.dp))

        AppTextField(
            value = email,
            onValueChange = {
                email = it
            },
            placeholder = "Adresse email",
            isError = emailError
        )

        Spacer(modifier = Modifier.height(18.dp))

        PasswordTextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = "Mot de passe",
            isError = passwordError
        )

        Spacer(modifier = Modifier.height(30.dp))

        PrimaryButton(
            text = "Se connecter",

            onClick = {

                emailError = email.isBlank()
                passwordError = password.isBlank()

                if (
                    !emailError &&
                    !passwordError
                ) {

                    navController.navigate("dashboard")
                }
            }
        )

        Spacer(modifier = Modifier.height(26.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Pas encore de compte ? "
            )

            Text(
                text = "S'inscrire",
                color = PrimaryGreen,
                fontWeight = FontWeight.Bold,

                modifier = Modifier.clickable {

                    navController.navigate("register")
                }
            )
        }
    }
}