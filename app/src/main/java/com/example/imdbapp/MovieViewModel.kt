package com.example.imdbapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.imdbapp.Model.Movie
import com.example.imdbapp.Repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MoviesRepository): ViewModel() {
    val movies : LiveData<List<Movie>> = repository.movies

    suspend fun getAllMovies(){
        withContext(Dispatchers.IO) {
            repository.getTopRatedMovies()
        }
    }
}