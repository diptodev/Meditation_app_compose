package com.excitedbroltd.meditationappcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.excitedbroltd.meditationappcompose.ui.screen.HomeScreen
import com.excitedbroltd.meditationappcompose.ui.theme.MeditationAppComposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationAppComposeTheme {
                HomeScreen()
            }
        }
    }
}
