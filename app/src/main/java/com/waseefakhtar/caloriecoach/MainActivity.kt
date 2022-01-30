package com.waseefakhtar.caloriecoach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.waseefakhtar.caloriecoach.ui.theme.CalorieCoachTheme
import com.waseefakhtar.onboarding_presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalorieCoachTheme {
                WelcomeScreen()
            }
        }
    }
}