package com.example.imdbapp.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.imdbapp.API.MoviesAPI
import com.example.imdbapp.Model.Movie
import com.example.imdbapp.Model.MovieResponse
import retrofit2.Response
import javax.inject.Inject

class MoviesRepository @Inject constructor(val moviesAPI: MoviesAPI) {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies get() = _movies

    suspend fun getTopRatedMovies() {
        val response = moviesAPI.getTopRatedMovies()
        if(response.isSuccessful && response.body() != null){
            Log.d("API response", response.body().toString())
            _movies.postValue(response.body()!!.results)
        } else {
            Log.d("API response", "Error")
        }
    }
}