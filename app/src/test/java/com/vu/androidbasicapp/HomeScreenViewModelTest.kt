package com.vu.androidbasicapp

import android.util.Log
import com.vu.androidbasicapp.home.data.DetailItem
import com.vu.androidbasicapp.home.data.RestfulApiDevRepositoryClass
import com.vu.androidbasicapp.home.data.TravelResponse
import com.vu.androidbasicapp.home.ui.HomeScreenViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeScreenViewModelTest {

    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var repository: RestfulApiDevRepositoryClass
    private val exampleResponseItem = TravelResponse(
        entities = listOf(DetailItem("Paris", "France", "Spring", "", "")),
        entityTotal = 1
    )
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        // Mock the repository
        repository = mockk()

        // Set the dispatcher for the ViewModel's scope
        Dispatchers.setMain(testDispatcher)

        // Mock the repository response with proper values
        coEvery { repository.getAllObjectsData() } returns TravelResponse(
            entities = listOf(
                DetailItem("Paris", "France", "Spring", "", ""),
                DetailItem("Tokyo", "Japan", "Autumn", "", "")
            ),
            entityTotal = 2
        )

        // Mock the Log class
        mockkStatic(Log::class)
        every { Log.d(any(), any()) } returns 0

        // Initialize the ViewModel
        viewModel = HomeScreenViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the Main dispatcher to the original one
    }

    @Test
    fun `test ViewModel calls API and updates StateFlow on init`() = runTest(testDispatcher) {
        // Advance time to allow the ViewModel's coroutine to execute
        advanceUntilIdle()

        // Verify that the greetingText is updated
        assertEquals("Travel", viewModel.greetingText.value)

        // Verify that the apiResponseObjects is updated with the mocked data
        val apiResponse = viewModel.apiResponseObjects.value
        assertEquals(2, apiResponse.size)
        assertEquals("Paris", apiResponse[0].destination)
        assertEquals("Tokyo", apiResponse[1].destination)
    }
}