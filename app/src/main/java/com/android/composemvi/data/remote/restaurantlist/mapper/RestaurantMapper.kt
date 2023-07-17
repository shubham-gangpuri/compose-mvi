package com.android.composemvi.data.remote.restaurantlist.mapper

import com.android.composemvi.data.remote.restaurantlist.dto.RestaurantsDto
import com.android.composemvi.domain.restaurantlist.dto.RestaurantDomain
import com.android.composemvi.domain.restaurantlist.dto.RestaurantsDomainDto

fun RestaurantsDto.toRestaurantsDomainDto(): RestaurantsDomainDto {
    return RestaurantsDomainDto(restaurantDomain = result?.map {
        RestaurantDomain(
            restaurantId = it.restaurantId,
            coverImage = it.coverImage,
            restaurantName = it.restaurantName,
            isOpen = it.isOpen,
            minimumOrder = it.minimumOrder
        )
    })
}