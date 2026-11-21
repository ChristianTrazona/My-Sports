package com.example.mysports.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TopLevelDestination(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : TopLevelDestination(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Account : TopLevelDestination(
        route = "account",
        title = "Account",
        icon = Icons.Default.GridView
    )

    object Profile : TopLevelDestination(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

    object MySports : TopLevelDestination(
        route = "my_sports",
        title = "My Sports",
        icon = Icons.Default.SportsSoccer
    )
}

object NavRoutes {
    val topLevelDestinations = listOf(
        TopLevelDestination.Home,
        TopLevelDestination.Account,
        TopLevelDestination.Profile,
        TopLevelDestination.MySports
    )

    const val SPORT_DETAIL_ROUTE = "sport_detail/{sportId}"
    fun createSportDetailRoute(sportId: String): String = "sport_detail/$sportId"
}
