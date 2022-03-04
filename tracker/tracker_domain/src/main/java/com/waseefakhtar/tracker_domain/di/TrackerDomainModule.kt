package com.waseefakhtar.tracker_domain.di

import com.waseefakhtar.core.domain.preferences.Preferences
import com.waseefakhtar.tracker_domain.repository.TrackerRepository
import com.waseefakhtar.tracker_domain.use_case.CalculateMealNutrients
import com.waseefakhtar.tracker_domain.use_case.DeleteTrackedFood
import com.waseefakhtar.tracker_domain.use_case.GetFoodsForDate
import com.waseefakhtar.tracker_domain.use_case.SearchFood
import com.waseefakhtar.tracker_domain.use_case.TrackFood
import com.waseefakhtar.tracker_domain.use_case.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}