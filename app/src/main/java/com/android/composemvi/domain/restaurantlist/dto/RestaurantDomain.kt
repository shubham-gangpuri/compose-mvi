package com.android.composemvi.domain.restaurantlist.dto

data class RestaurantDomain(
    val restaurantId: Long? = null,
    val coverImage: String? = null,
    val restaurantName: String? = null,
    val isOpen: Boolean? = null,
    val minimumOrder: Int? = null,
    val isChecked: Boolean = false
)
