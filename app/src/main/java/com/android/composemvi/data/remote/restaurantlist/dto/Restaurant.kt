package com.android.composemvi.data.remote.restaurantlist.dto

import com.squareup.moshi.Json

data class Restaurant(
    @field:Json(name = "id") val restaurantId: Long,
    @field:Json(name = "coverImageUrl") val coverImage: String? = null,
    @field:Json(name = "name") val restaurantName: String? = null,
    @field:Json(name = "open") val isOpen: Boolean? = null,
    @field:Json(name = "minimumOrder") val minimumOrder: Int? = null
)