package com.android.composemvi.domain.restaurantlist.dto

data class RestaurantDomain(
    val restaurantId: Long? = null,
    val coverImage: String? = null,
    val restaurantName: String,
    val openStatus: String,
    val minimumOrder: Int? = null,
    var isChecked: Boolean = false
)
