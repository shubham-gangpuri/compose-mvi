package com.android.composemvi.ui.home

import com.android.composemvi.MainDispatcherRule
import com.android.composemvi.domain.restaurantlist.RestaurantListUseCase
import com.android.composemvi.domain.restaurantlist.dto.RestaurantsDomainDto
import com.android.composemvi.utils.Resource
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var homeViewModel: HomeViewModel
    private val restaurantListUseCase: RestaurantListUseCase = mockk()

    @Test
    fun `WHEN HomeViewModel initialized THEN invoke RestaurantListUseCase`() {
        val restaurantsDomainDto = RestaurantsDomainDto()
        every {
            runBlocking {
                restaurantListUseCase.invoke()
            }
        } returns Resource.Success(restaurantsDomainDto)

        homeViewModel = HomeViewModel(restaurantListUseCase)

        Assert.assertEquals(homeViewModel.state.restaurantsDomainDto, restaurantsDomainDto)
    }

    @Test
    fun `GIVEN HomeViewModel initialized WHEN invoke RestaurantListUseCase with error THEN state return error`() {
        every {
            runBlocking {
                restaurantListUseCase.invoke()
            }
        } returns Resource.Error("Error occurred.")

        homeViewModel = HomeViewModel(restaurantListUseCase)

        Assert.assertEquals(homeViewModel.state.error, "Error occurred.")
    }

}