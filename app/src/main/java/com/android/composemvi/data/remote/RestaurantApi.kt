package com.android.composemvi.data.remote

import com.android.composemvi.data.remote.restaurantlist.dto.RestaurantsDto
import retrofit2.http.GET

interface RestaurantApi {

    @GET("10bis/10bis-mobile-home-assignment/db")
    suspend fun getRestaurants(): RestaurantsDto

}