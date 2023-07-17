package com.android.composemvi.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.composemvi.domain.restaurantlist.RestaurantListUseCase
import com.android.composemvi.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val restaurantListUseCase: RestaurantListUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeScreenState())
        private set

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            state = when(val result = restaurantListUseCase()){
                is Resource.Success ->{
                    state.copy(
                        isLoading = false,
                        restaurantsDomainDto = result.data
                    )
                }

                is Resource.Error -> {
                    state.copy(
                        isLoading = false,
                        restaurantsDomainDto = null,
                        error = result.message
                    )
                }
            }
        }
    }

}