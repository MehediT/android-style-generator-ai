package com.toure.mehedi.style_generator_ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.toure.mehedi.style_generator_ai.ui.showcase.DesignSystemShowcase
import com.toure.mehedi.style_generator_ai.ui.theme.AndroidstylegeneratoraiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidstylegeneratoraiTheme {
                DesignSystemShowcase()
            }
        }
    }
}