package com.android.composemvi.domain.restaurantlist

import com.android.composemvi.domain.restaurantlist.dto.RestaurantsDomainDto
import com.android.composemvi.utils.Resource

interface RestaurantListRepo {
    suspend fun getRestaurantList(): Resource<RestaurantsDomainDto>
}