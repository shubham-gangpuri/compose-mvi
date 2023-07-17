package com.android.composemvi.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.composemvi.R
import com.android.composemvi.domain.restaurantlist.dto.RestaurantDomain
import com.android.composemvi.ui.theme.Typography

@Composable
fun RestaurantItemUI(
    restaurantDomain: RestaurantDomain,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = restaurantDomain.restaurantName ?: "",
                color = Color.Black,
                fontSize = Typography.h4.fontSize
            )
            AsyncImage(
                model = restaurantDomain.coverImage,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = modifier.fillMaxWidth().height(100.dp),
                error = painterResource(R.drawable.ic_launcher_background)
            )
        }
    }
}