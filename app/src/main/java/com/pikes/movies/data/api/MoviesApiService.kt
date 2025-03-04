package com.pikes.movies.data.api

import com.pikes.movies.data.model.Movies
import com.pikes.movies.utils.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {
    @GET("/movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = AppConstants.API_KEY,
        @Query("page") page: Int = 1
    ): Response<Movies>
}