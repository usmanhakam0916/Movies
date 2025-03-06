package com.pikes.movies.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pikes.movies.ui.screens.HomeScreen
import com.pikes.movies.ui.theme.MoviesTheme
import com.pikes.movies.ui.viewmodel.MoviesViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesTheme {
                HomeScreen(viewModel)
            }
        }
    }
}
