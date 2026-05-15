package com.stocknow.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.stocknow.app.ui.navigation.StockNowNavGraph
import com.stocknow.app.ui.theme.StockNowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StockNowTheme {
                val navController = rememberNavController()
                StockNowNavGraph(navController = navController)
            }
        }
    }
}
