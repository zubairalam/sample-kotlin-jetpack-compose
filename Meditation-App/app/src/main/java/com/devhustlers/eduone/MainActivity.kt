package com.devhustlers.eduone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.devhustlers.eduone.ui.theme.FlowerMeditationAppTheme
import com.devhustlers.eduone.ui.utils.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FlowerMeditationAppTheme { // its lambda function being passed as second argument of FlowerMeditationAppTheme higher order function
                // This is the body of the lambda function which will get executed inside FlowerMeditationAppTheme
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                ) {
                    Navigation()
                }
            }
        }
    }
}