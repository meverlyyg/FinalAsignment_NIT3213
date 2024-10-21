package com.vu.androidbasicapp

import com.vu.androidbasicapp.home.data.DetailItem
import com.vu.androidbasicapp.home.data.TravelResponse
import com.vu.androidbasicapp.home.ui.recyclerview.MyRecyclerViewAdapter
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MyRecyclerViewAdapterTest {

    private lateinit var adapter: MyRecyclerViewAdapter
    private val mockNavigationFunction: (DetailItem) -> Unit = {}
    private val exampleDetailItem = DetailItem(
        destination = "Paris",
        country = "France",
        bestSeason = "Spring",
        popularAttraction = "Eiffel Tower",
        description = "A beautiful city with rich history."
    )

    @Before
    fun setUp() {
        // Initialize the adapter and mock notifyDataSetChanged
        adapter = spyk(MyRecyclerViewAdapter(navigationFunction = mockNavigationFunction))
        every { adapter.notifyDataSetChanged() } returns Unit
    }

    @Test
    fun `getItemCount returns correct size`() {
        // Given: A list of travel destinations
        val dataList = mutableListOf(
            exampleDetailItem,
            exampleDetailItem.copy(destination = "Tokyo", country = "Japan"),
            exampleDetailItem.copy(destination = "New York", country = "USA")
        )
        adapter.setData(dataList)

        // When: Getting the item count from the adapter
        val itemCount = adapter.getItemCount()

        // Then: The item count should be 3
        assertEquals(3, itemCount)
    }

    @Test
    fun `setData updates dataList and calls notifyDataSetChanged`() {
        // Given: A new list of travel destinations
        val newDataList = listOf(
            exampleDetailItem.copy(destination = "Sydney", country = "Australia"),
            exampleDetailItem.copy(destination = "Berlin", country = "Germany")
        )

        // When: Updating the adapter's data
        adapter.setData(newDataList)

        // Then: Verify that the dataList size is updated and notifyDataSetChanged is called
        assertEquals(2, adapter.getItemCount()) // Check that the adapter's data has 2 items
        verify { adapter.notifyDataSetChanged() } // Check that notifyDataSetChanged is called
    }
}