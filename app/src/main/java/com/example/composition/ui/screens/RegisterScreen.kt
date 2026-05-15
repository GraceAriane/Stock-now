package com.example.composition.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composition.navigation.AppNavigation
import com.example.composition.ui.components.*
import com.example.composition.ui.theme.BackgroundGray
import com.example.composition.ui.theme.PrimaryGreen

@Composable
fun RegisterScreen(
    navController: NavController
) {

    var fullName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var fullNameError by remember {
        mutableStateOf(false)
    }

    var emailError by remember {
        mutableStateOf(false)
    }

    var passwordError by remember {
        mutableStateOf(false)
    }

    var confirmPasswordError by remember {
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
            title = "Inscription",
            subtitle = "Créez votre compte pour commencer."
        )

        Spacer(modifier = Modifier.height(40.dp))

        AppTextField(
            value = fullName,
            onValueChange = {
                fullName = it
            },
            placeholder = "Nom complet",
            isError = fullNameError
        )

        Spacer(modifier = Modifier.height(18.dp))

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

        Spacer(modifier = Modifier.height(18.dp))

        PasswordTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
            },
            placeholder = "Confirmer le mot de passe",
            isError = confirmPasswordError
        )

        Spacer(modifier = Modifier.height(30.dp))

        PrimaryButton(
            text = "Créer un compte",

            onClick = {

                fullNameError = fullName.isBlank()
                emailError = email.isBlank()

                passwordError =
                    password.length < 6

                confirmPasswordError =
                    confirmPassword != password

                if (
                    !fullNameError &&
                    !emailError &&
                    !passwordError &&
                    !confirmPasswordError
                ) {

                    navController.navigate("login")
                }
            }
        )

        Spacer(modifier = Modifier.height(26.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Vous avez déjà un compte ? "
            )

            Text(
                text = "Connexion",
                color = PrimaryGreen,
                fontWeight = FontWeight.Bold,

                modifier = Modifier.clickable {

                    navController.navigate("login")
                }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

