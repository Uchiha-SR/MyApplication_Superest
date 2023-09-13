package dev.android.myapplication_superest.graphs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dev.android.myapplication_superest.presentation.screens.SplashScreen
import dev.android.myapplication_superest.presentation.screens.WelcomeScreen
import kotlinx.coroutines.delay


fun NavGraphBuilder.authNavGraph(navController: NavHostController, ) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Splash.route
    ) {
        composable(route = AuthScreen.Splash.route) {
              SplashScreen(navController)
            }


          /*      onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                },
                onForgotClick = {
                    navController.navigate(AuthScreen.Forgot.route)
                }
            )  */

        composable(route = AuthScreen.Welcome.route) {
            WelcomeScreen(
                onButtonClicked = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                } )
        }
      /*  composable(route = AuthScreen.Forgot.route) {
            ScreenContent(name = AuthScreen.Forgot.route) {}
        } */
    }
}

sealed class AuthScreen(val route: String) {
    object Splash : AuthScreen(route = "SPLASH")
    object Welcome : AuthScreen(route = "WELCOME")
  //  object Forgot : AuthScreen(route = "FORGOT")
}