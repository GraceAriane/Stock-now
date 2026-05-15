package com.stocknow.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stocknow.app.ui.theme.*

data class NotifItem(
    val message: String,
    val boldWord: String,
    val time: String,
    val dotColor: Color,
)

private val notifData = listOf(
    // Today
    NotifItem("Vous avez ajouté un Produit A",     "Produit A",  "2 min", Teal400),
    NotifItem("Vous avez ajouté un Produit B",     "Produit B",  "6 min", Teal400),
    NotifItem("Vous avez vendu un Produit D",      "Produit D",  "5 hrs", Teal400),
    // Yesterday
    NotifItem("Le Produit B est en seuil critique","Produit B",  "1 jr",  Amber400),
    NotifItem("Vous avez ajouté un nouveau produit","nouveau produit","1 jr", Teal400),
    NotifItem("Mise à jour disponible",            "disponible", "1 jr",  Teal400),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen(onBack: () -> Unit) {
    Scaffold(
        containerColor = Surface1,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Outlined.ArrowBack, "Retour", tint = TextPrimary)
                    }
                },
                title = { Text("Notifications", style = MaterialTheme.typography.titleLarge) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Surface0),
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            item {
                SectionHeader("Aujourd'hui")
            }
            items(notifData.take(3)) { notif ->
                NotifRow(notif)
            }
            item {
                SectionHeader("Hier")
            }
            items(notifData.drop(3)) { notif ->
                NotifRow(notif)
            }
            item { Spacer(Modifier.height(16.dp)) }
        }
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        title,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
        style = MaterialTheme.typography.labelSmall,
        color = TextHint,
        letterSpacing = 0.7.sp,
    )
}

@Composable
private fun NotifRow(notif: NotifItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 3.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Surface2)
            .padding(horizontal = 12.dp, vertical = 11.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        // Colored dot
        Box(
            modifier = Modifier
                .padding(top = 4.dp)
                .size(8.dp)
                .clip(CircleShape)
                .background(notif.dotColor),
        )

        // Annotated text with bold product name
        val annotated = buildAnnotatedString {
            val idx = notif.message.indexOf(notif.boldWord)
            if (idx >= 0) {
                append(notif.message.substring(0, idx))
                withStyle(SpanStyle(fontWeight = FontWeight.Medium, color = TextPrimary)) {
                    append(notif.boldWord)
                }
                append(notif.message.substring(idx + notif.boldWord.length))
            } else {
                append(notif.message)
            }
        }
        Text(
            annotated,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFFCCCCCC),
            lineHeight = 17.sp,
        )

        // Time
        Text(notif.time, fontSize = 10.sp, color = TextHint)
    }
}
