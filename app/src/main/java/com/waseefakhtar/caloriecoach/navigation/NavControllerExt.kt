package com.waseefakhtar.caloriecoach.navigation

import androidx.navigation.NavController
import com.waseefakhtar.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}