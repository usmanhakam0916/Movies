package com.pikes.movies.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pikes.movies.data.api.RetrofitInstance
import com.pikes.movies.data.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MoviesViewModel: ViewModel() {
    private val _moviesUiState = MutableStateFlow<List<Result>>(emptyList())
    val moviesUiState: StateFlow<List<Result>> = _moviesUiState

    init {
        getNowPlayingMovies()
    }

    private fun getNowPlayingMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = RetrofitInstance.moviesApiService.getNowPlayingMovies()
                val movies = result?.body()!!.results
                _moviesUiState.value = movies
            } catch (e: Exception) {
                Log.d("Result", "${e.message.toString()}")
            }
        }
    }
}