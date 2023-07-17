package com.android.composemvi.data.remote.restaurantlist.repo

import com.android.composemvi.data.remote.RestaurantApi
import com.android.composemvi.data.remote.restaurantlist.mapper.toRestaurantsDomainDto
import com.android.composemvi.domain.restaurantlist.RestaurantListRepo
import com.android.composemvi.domain.restaurantlist.dto.RestaurantsDomainDto
import com.android.composemvi.utils.Resource
import javax.inject.Inject

class RestaurantListRepoImpl @Inject constructor(
    private val restaurantApi: RestaurantApi
) : RestaurantListRepo {

    override suspend fun getRestaurantList(): Resource<RestaurantsDomainDto> = try {
        Resource.Success(
            restaurantApi.getRestaurants().toRestaurantsDomainDto()
        )
    } catch (e: Exception) {
        e.printStackTrace()
        Resource.Error(e.stackTraceToString())
    }
}