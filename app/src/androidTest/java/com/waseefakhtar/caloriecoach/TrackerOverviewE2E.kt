package com.waseefakhtar.caloriecoach

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.waseefakhtar.caloriecoach.repository.TrackerRepositoryFake
import com.waseefakhtar.core.domain.model.ActivityLevel
import com.waseefakhtar.core.domain.model.Gender
import com.waseefakhtar.core.domain.model.GoalType
import com.waseefakhtar.core.domain.model.UserInfo
import com.waseefakhtar.core.domain.preferences.Preferences
import com.waseefakhtar.core.domain.use_case.FilterOutDigits
import com.waseefakhtar.tracker_domain.use_case.CalculateMealNutrients
import com.waseefakhtar.tracker_domain.use_case.DeleteTrackedFood
import com.waseefakhtar.tracker_domain.use_case.GetFoodsForDate
import com.waseefakhtar.tracker_domain.use_case.SearchFood
import com.waseefakhtar.tracker_domain.use_case.TrackFood
import com.waseefakhtar.tracker_domain.use_case.TrackerUseCases
import com.waseefakhtar.tracker_presentation.search.SearchViewModel
import com.waseefakhtar.tracker_presentation.tracker_overview.TrackerOverviewViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@HiltAndroidTest
class TrackerOverviewE2E {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var repositoryFake: TrackerRepositoryFake
    private lateinit var trackerUseCases: TrackerUseCases
    private lateinit var preferences: Preferences
    private lateinit var trackerOverviewViewModel: TrackerOverviewViewModel
    private lateinit var searchViewModel: SearchViewModel

    private lateinit var navController: NavHostController

    @Before
    fun setUp() {
        preferences = mockk(relaxed = true)
        every { preferences.loadUserInfo() } returns UserInfo(
            gender = Gender.Male,
            age = 20,
            weight = 80f,
            height = 180,
            activityLevel = ActivityLevel.Medium,
            goalType = GoalType.KeepWeight,
            carbRatio = 0.4f,
            proteinRatio = 0.3f,
            fatRatio = 0.3f
        )
        repositoryFake = TrackerRepositoryFake()
        trackerUseCases = TrackerUseCases(
            trackFood = TrackFood(repositoryFake),
            searchFood = SearchFood(repositoryFake),
            getFoodsForDate = GetFoodsForDate(repositoryFake),
            deleteTrackedFood = DeleteTrackedFood(repositoryFake),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
        trackerOverviewViewModel = TrackerOverviewViewModel(
            preferences = preferences,
            trackerUseCases = trackerUseCases
        )
        searchViewModel = SearchViewModel(
            trackerUseCases = trackerUseCases,
            filterOutDigits = FilterOutDigits()
        )
        composeRule.setContent {
            // TODO
        }
    }
}