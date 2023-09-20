package dev.android.myapplication_superest.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.android.myapplication_superest.presentation.screens.AccountScreen
import dev.android.myapplication_superest.presentation.screens.CartScreen
import dev.android.myapplication_superest.presentation.screens.ExploreScreen
import dev.android.myapplication_superest.presentation.screens.FavouriteScreen
import dev.android.myapplication_superest.presentation.screens.ShopScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavItem.Shop.route
    ) {
        composable(route = BottomNavItem.Shop.route) {
            ShopScreen()
        }
        composable(route = BottomNavItem.Explore.route) {
            ExploreScreen()
        }
        composable(route = BottomNavItem.Cart.route) {
           CartScreen()
        }
        composable(route = BottomNavItem.Favourite.route) {
            FavouriteScreen()
        }
        composable(route = BottomNavItem.Account.route) {
           AccountScreen()
        }

    }
}

