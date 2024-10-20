package com.example.imdbapp.API

import com.example.imdbapp.Constants
import com.example.imdbapp.Model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface MoviesAPI {
//    https://api.themoviedb.org/3/discover/movie
    @GET("movie")
    @Headers("Authorization: Bearer ${Constants.API_KEY}")
    suspend fun getTopRatedMovies(): Response<MovieResponse>
}