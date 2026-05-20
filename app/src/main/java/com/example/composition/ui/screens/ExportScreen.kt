package com.example.composition.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material.icons.outlined.PictureAsPdf
import androidx.compose.material.icons.outlined.TableChart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composition.ui.viewmodels.ExportViewModel

@Composable
fun ExportScreen(viewModel: ExportViewModel = viewModel()) {

    val isExporting by viewModel.isExporting

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {

        HeaderSection()

        if (isExporting) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                color = Color(0xFF0F766E),
                trackColor = Color(0xFF0F766E).copy(alpha = 0.1f)
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            item {
                ExportCard(
                    title = "Exporter en PDF",
                    description = "Télécharger le rapport complet en PDF",
                    icon = Icons.Outlined.PictureAsPdf,
                    color = Color(0xFFDC2626),
                    onClick = { viewModel.genererExport("PDF") },
                    isLoading = isExporting
                )

                ExportCard(
                    title = "Exporter en Excel",
                    description = "Télécharger les données en format Excel",
                    icon = Icons.Outlined.TableChart,
                    color = Color(0xFF15803D),
                    onClick = { viewModel.genererExport("Excel") },
                    isLoading = isExporting
                )

                ExportCard(
                    title = "Exporter les mouvements",
                    description = "Historique complet des mouvements",
                    icon = Icons.Outlined.FileDownload,
                    color = Color(0xFF0F766E),
                    onClick = { viewModel.genererExport("Mouvements") },
                    isLoading = isExporting
                )

                if (viewModel.exportStatus.value.isNotEmpty()) {
                    Text(
                        text = viewModel.exportStatus.value,
                        modifier = Modifier.padding(16.dp),
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = "Exportation",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Téléchargez vos rapports",
            color = Color.Gray,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ExportCard(
    title: String,
    description: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color,
    onClick: () -> Unit,
    isLoading: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.12f)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Box(modifier = Modifier.size(60.dp), contentAlignment = Alignment.Center) {
                    Icon(imageVector = icon, contentDescription = null, tint = color)
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = description, color = Color.Gray, fontSize = 14.sp)
            }

            Button(
                onClick = onClick,
                enabled = !isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = color),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text(if (isLoading) "..." else "Exporter")
            }
        }
    }
}
