package com.android.composemvi.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
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
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Long, Boolean) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(bottom = 16.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        AsyncImage(
            model = restaurantDomain.coverImage,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(percent = 10))
                .aspectRatio(2.5f)
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = size.height / 3,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient, blendMode = BlendMode.Multiply)
                    }
                }
                .testTag("restImg"),
            error = painterResource(R.drawable.ic_launcher_background)
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = restaurantDomain.openStatus,
                color = White,
                fontSize = Typography.body1.fontSize,
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = restaurantDomain.restaurantName,
                color = White,
                fontSize = Typography.h5.fontSize
            )
        }
        CustomCheckbox(
            checked = checked,
            onCheckedChange = { checked ->
                onCheckedChange(restaurantDomain.restaurantId, checked)
            },
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .padding(8.dp)
        )
    }
}

@Composable
fun CustomCheckbox(checked: Boolean, onCheckedChange: (Boolean) -> Unit, modifier: Modifier) {
    Icon(
        imageVector = if (checked) Icons.Default.Star else Icons.Outlined.Star,
        contentDescription = "Custom Checkbox",
        tint = if (checked) Color.Red else Color.White,
        modifier = modifier
            .clickable { onCheckedChange(!checked) }
            .size(40.dp)
    )
}