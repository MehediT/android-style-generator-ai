package com.toure.mehedi.style_generator_ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.toure.mehedi.style_generator_ai.navigation.NavGraph
import com.toure.mehedi.style_generator_ai.ui.theme.AndroidstylegeneratoraiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidstylegeneratoraiTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}