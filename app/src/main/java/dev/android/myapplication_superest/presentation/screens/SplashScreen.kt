package dev.android.myapplication_superest.presentation.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.android.myapplication_superest.R
import kotlinx.coroutines.delay
import androidx.compose.foundation.Image
@Composable
fun SplashScreen(navController: NavController){

    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        navController.navigate("Welcome")
    }

    // Image
    Box(contentAlignment = Alignment.Center,

        modifier = Modifier.fillMaxSize().
        background(
            color = colorResource(R.color.green)) ){
        Image(painter = painterResource(id = R.drawable.ic_carrot),
            contentDescription = "Logo",
            modifier = Modifier.size(48.dp)
        )
    }
}

