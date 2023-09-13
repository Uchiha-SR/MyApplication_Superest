package dev.android.myapplication_superest.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme

import androidx.compose.foundation.layout.*



import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite

import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import dev.android.myapplication_superest.R
import dev.android.myapplication_superest.ui.FilledButton

@Composable
fun WelcomeScreen(onButtonClicked: ()-> Unit){


    val isDarkTheme = isSystemInDarkTheme()


        Box(
            modifier = Modifier
                .fillMaxSize()
                //  .background(LightGray)
                .paint(
                    painterResource(id = R.drawable.welcome_image),
                    contentScale = ContentScale.FillBounds
                )

                .padding(top=120.dp,bottom = 24.dp)
            //.size(88.dp),
        ) {
            Column(
                modifier=Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Image(
                    painter = painterResource(
                        id = R.drawable.ic_carrot,
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        //    .align(Alignment.Center)
                        //  .clip(RoundedCornerShape(16.dp))
                        //   .background(Black)
                        .size(80.dp),
                    contentScale = ContentScale.Crop,
                )

                Text(
                    text = "Welcome",
                    //    modifier = Modifier.align(Alignment.Center),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontStyle = FontStyle.Normal,
                        letterSpacing = 0.5.em,
                        //  background = Color.LightGray,
                    )
                )

                Text(
                    text = "To Our Store",
                    //     modifier = Modifier.align(Alignment.Center),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontStyle = FontStyle.Normal,
                        letterSpacing = 0.5.em,
                        //  background = Color.LightGray,
                    )
                )

                Text(
                    text = "Get your groceries in as fast as one hour",
                    //      modifier = Modifier.align(Alignment.Center),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        letterSpacing = 0.5.em,
                        //  background = Color.LightGray,
                    )
                )


                FilledButton(
                    text = stringResource(id = R.string.get_started),
                    onButtonClicked = onButtonClicked,
                    isDarkTheme = isDarkTheme
                )
            }
        }
}

