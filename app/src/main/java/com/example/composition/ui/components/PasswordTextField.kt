package com.example.composition.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.composition.R // Assure-toi que l'import R de ton projet est présent
import com.example.composition.ui.theme.PrimaryGreen
import com.example.composition.ui.theme.TextFieldBorder

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isError: Boolean = false
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp),
        shape = RoundedCornerShape(14.dp),
        singleLine = true,
        placeholder = {
            Text(text = placeholder)
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    // Utilisation de painterResource pour charger les XML du dossier drawable
                    painter = painterResource(
                        id = if (passwordVisible) R.drawable.ic_visibility_on else R.drawable.ic_visibility_off
                    ),
                    contentDescription = if (passwordVisible) "Cacher le mot de passe" else "Afficher le mot de passe",
                    tint = TextFieldBorder // Tu peux aussi utiliser LocalContentColor.current
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = PrimaryGreen,
            unfocusedBorderColor = TextFieldBorder,
            errorBorderColor = MaterialTheme.colorScheme.error
        ),
        isError = isError
    )
}