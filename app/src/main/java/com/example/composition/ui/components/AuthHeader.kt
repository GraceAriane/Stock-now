package com.example.composition.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composition.ui.theme.DarkText
import com.example.composition.ui.theme.LightText

@Composable
fun AuthHeader(
    title: String,
    subtitle: String
) {

    Column {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = DarkText
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = subtitle,
            fontSize = 15.sp,
            lineHeight = 22.sp,
            color = LightText
        )
    }
}