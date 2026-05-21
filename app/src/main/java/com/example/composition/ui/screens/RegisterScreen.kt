package com.example.composition.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composition.navigation.Screen
import com.example.composition.ui.components.*
import com.example.composition.ui.theme.BackgroundGray
import com.example.composition.ui.theme.PrimaryGreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun RegisterScreen(navController: NavController) {
    val context = LocalContext.current
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var fullNameError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var confirmPasswordError by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

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
            onValueChange = { fullName = it; fullNameError = false },
            placeholder = "Nom complet",
            isError = fullNameError
        )

        Spacer(modifier = Modifier.height(18.dp))

        AppTextField(
            value = email,
            onValueChange = { email = it; emailError = false },
            placeholder = "Adresse email",
            isError = emailError
        )

        Spacer(modifier = Modifier.height(18.dp))

        PasswordTextField(
            value = password,
            onValueChange = { password = it; passwordError = false },
            placeholder = "Mot de passe",
            isError = passwordError
        )

        Spacer(modifier = Modifier.height(18.dp))

        PasswordTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it; confirmPasswordError = false },
            placeholder = "Confirmer le mot de passe",
            isError = confirmPasswordError
        )

        Spacer(modifier = Modifier.height(30.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.fillMaxWidth().wrapContentWidth(), color = PrimaryGreen)
        } else {
            PrimaryButton(
                text = "Créer un compte",
                onClick = {
                    fullNameError = fullName.isBlank()
                    emailError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                    passwordError = password.length < 6
                    confirmPasswordError = confirmPassword != password

                    if (!fullNameError && !emailError && !passwordError && !confirmPasswordError) {
                        isLoading = true
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                            .addOnSuccessListener { authResult ->
                                val userId = authResult.user?.uid
                                val userMap = hashMapOf(
                                    "fullName" to fullName,
                                    "email" to email,
                                    "createdAt" to System.currentTimeMillis()
                                )
                                
                                userId?.let { id ->
                                    FirebaseFirestore.getInstance().collection("users").document(id)
                                        .set(userMap)
                                        .addOnSuccessListener {
                                            isLoading = false
                                            navController.navigate(Screen.Dashboard.route) {
                                                popUpTo(Screen.Register.route) { inclusive = true }
                                            }
                                        }
                                        .addOnFailureListener { e ->
                                            isLoading = false
                                            Toast.makeText(context, "Erreur Firestore: ${e.message}", Toast.LENGTH_LONG).show()
                                        }
                                }
                            }
                            .addOnFailureListener { e ->
                                isLoading = false
                                Toast.makeText(context, "Erreur Auth: ${e.message}", Toast.LENGTH_LONG).show()
                            }
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(26.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Vous avez déjà un compte ? ")
            Text(
                text = "Connexion",
                color = PrimaryGreen,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.Login.route)
                }
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    val navController = rememberNavController()
    RegisterScreen(navController = navController)
}
