package com.faisal.retrofit_kotlin.remote

import com.faisal.retrofit_kotlin.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/top_rated")
    fun getTopRatedMovie(@Query("api_key") apiKey: String): Call<MovieResponse>

    @GET("movie/{id}")
    fun getMovieDetails(@Path("id") id: Int, @Query("api_key") apiKey: String): Call<MovieResponse>


}