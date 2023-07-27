package com.android.composemvi.ui.home

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.printToLog
import com.android.composemvi.domain.restaurantlist.dto.RestaurantDomain
import com.android.composemvi.ui.MainActivity
import org.junit.Rule
import org.junit.Test


class RestaurantItemUIKtTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun given_correct_restaurantDomain_values_WHEN_RestaurantItemUI_called_THEN_Show_list_item() {
        val restaurantDomain = RestaurantDomain(
            restaurantId = 123,
            coverImage = null,
            restaurantName = "Just Eat Takeaway",
            openStatus = "Open",
            minimumOrder = 30,
            isChecked = false
        )
        rule.setContent {
            RestaurantItemUI(restaurantDomain = restaurantDomain, backgroundColor = Color.White)
        }
        rule.onAllNodesWithText("Just Eat Takeaway").printToLog("XXX")
    }

}