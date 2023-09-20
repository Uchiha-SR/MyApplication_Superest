package dev.android.myapplication_superest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import dev.android.myapplication_superest.graphs.RootNavigationGraph
import dev.android.myapplication_superest.ui.theme.MyApplication_SuperestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this);
        setContent {
            MyApplication_SuperestTheme {
                // A surface container using the 'background' color from the theme


                    RootNavigationGraph(navController = rememberNavController())
                }
            }
        }

}


