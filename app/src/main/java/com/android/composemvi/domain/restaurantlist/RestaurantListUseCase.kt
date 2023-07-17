package com.android.composemvi.domain.restaurantlist

import com.android.composemvi.domain.restaurantlist.dto.RestaurantsDomainDto
import com.android.composemvi.utils.Resource
import javax.inject.Inject

class RestaurantListUseCase @Inject constructor(
    private val restaurantListRepo: RestaurantListRepo
) {

    suspend operator fun invoke(): Resource<RestaurantsDomainDto> =
        restaurantListRepo.getRestaurantList()

}