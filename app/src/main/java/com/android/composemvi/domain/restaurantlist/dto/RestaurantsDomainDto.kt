package com.android.composemvi.domain.restaurantlist.dto

data class RestaurantsDomainDto(
    val savedItems: Int = 0,
    val restaurantDomain: List<RestaurantDomain>? = null
)