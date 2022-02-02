package com.waseefakhtar.tracker_domain.repository

import com.waseefakhtar.tracker_domain.model.TrackableFood
import com.waseefakhtar.tracker_domain.model.TrackedFood
import java.time.LocalDate
import kotlinx.coroutines.flow.Flow

interface TrackerRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    suspend fun insertTrackedFood(food: TrackedFood)

    suspend fun deleteTrackedFood(food: TrackedFood)

    fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}