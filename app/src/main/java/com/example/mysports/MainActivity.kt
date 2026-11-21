package com.example.mysports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mysports.data.SportRepository
import com.example.mysports.ui.components.BottomNavigationBar
import com.example.mysports.ui.navigation.NavRoutes
import com.example.mysports.ui.navigation.TopLevelDestination
import com.example.mysports.ui.screens.AccountScreen
import com.example.mysports.ui.screens.HomeScreen
import com.example.mysports.ui.screens.MySportsScreen
import com.example.mysports.ui.screens.ProfileScreen
import com.example.mysports.ui.screens.SportDetailScreen
import com.example.mysports.ui.theme.MySportsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MySportsTheme(dynamicColor = false) {
                MySportsApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySportsApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val isTopLevelDestination = NavRoutes.topLevelDestinations.any { it.route == currentRoute }

    val topBarTitle = when {
        currentRoute == TopLevelDestination.Home.route -> TopLevelDestination.Home.title
        currentRoute == TopLevelDestination.Account.route -> TopLevelDestination.Account.title
        currentRoute == TopLevelDestination.Profile.route -> TopLevelDestination.Profile.title
        currentRoute == TopLevelDestination.MySports.route -> TopLevelDestination.MySports.title
        currentRoute?.startsWith("sport_detail/") == true -> {
            val sportId = navBackStackEntry?.arguments?.getString("sportId") ?: ""
            SportRepository.getSportById(sportId)?.name ?: "Sport Details"
        }
        else -> "My Sports"
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = topBarTitle,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    if (!isTopLevelDestination && navController.previousBackStackEntry != null) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EE),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                currentRoute = currentRoute
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = TopLevelDestination.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(TopLevelDestination.Home.route) {
                HomeScreen()
            }
            composable(TopLevelDestination.Account.route) {
                AccountScreen()
            }
            composable(TopLevelDestination.Profile.route) {
                ProfileScreen()
            }
            composable(TopLevelDestination.MySports.route) {
                MySportsScreen(
                    onSportClick = { sportId ->
                        navController.navigate(NavRoutes.createSportDetailRoute(sportId))
                    }
                )
            }
            composable(
                route = NavRoutes.SPORT_DETAIL_ROUTE,
                arguments = listOf(
                    navArgument("sportId") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val sportId = backStackEntry.arguments?.getString("sportId") ?: ""
                SportDetailScreen(
                    sportId = sportId,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}
