package com.android.composemvi.ui.home

import com.android.composemvi.domain.restaurantlist.dto.RestaurantsDomainDto

data class HomeScreenState(
    val restaurantsDomainDto: RestaurantsDomainDto? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)