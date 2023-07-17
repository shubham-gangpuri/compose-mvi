package com.android.composemvi.data.remote.restaurantlist.dto


import com.squareup.moshi.Json

data class RestaurantsDto(
    @field:Json(name = "restaurants") val result: List<Restaurant>? = null
)