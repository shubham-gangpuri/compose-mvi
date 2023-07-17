package com.android.composemvi.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import com.android.composemvi.ui.home.HomeViewModel
import com.android.composemvi.ui.home.RestaurantItemUI
import com.android.composemvi.ui.theme.ComposeMviAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMviAppTheme {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val restaurantList = viewModel.state.restaurantsDomainDto?.restaurantDomain
                    if (viewModel.state.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                    LazyColumn() {
                        restaurantList?.let {
                            items(items = restaurantList) {
                                RestaurantItemUI(
                                    restaurantDomain = it,
                                    backgroundColor = Color.Gray,
                                )
                            }
                        }
                    }
                    viewModel.state.error?.let { error ->
                        Text(
                            text = error,
                            color = Color.Red,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
