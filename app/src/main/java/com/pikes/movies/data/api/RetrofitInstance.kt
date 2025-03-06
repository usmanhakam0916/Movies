package com.pikes.movies.data.api

import com.pikes.movies.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(AppConstants.BASE_URL)
        .build()

    val moviesApiService: MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java)
    }
}