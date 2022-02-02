package com.waseefakhtar.tracker_presentation.search

import com.waseefakhtar.tracker_domain.model.TrackableFood

data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)