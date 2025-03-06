package com.pikes.movies.data.repository

import com.pikes.movies.data.api.MoviesApiService
import com.pikes.movies.data.model.Movies
import retrofit2.Response

class MoviesRepository(private val apiService: MoviesApiService) {
    suspend fun getNowPlayingMovies(): Response<Movies> {
        return apiService.getNowPlayingMovies()
    }
}