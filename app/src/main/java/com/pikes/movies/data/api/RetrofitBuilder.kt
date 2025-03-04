package com.pikes.movies.data.api

import com.pikes.movies.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitBuilder {

    val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(AppConstants.BASE_URL)
        .build()
}