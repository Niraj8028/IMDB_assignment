package com.example.imdbapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbapp.Repository.MoviesRepository
import com.example.imdbapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var viewModel: MovieViewModel
//    private lateinit var binding : ActivityMainBinding
    private lateinit var movieRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(layoutInflater, R.layout.activity_main)
        movieRv = findViewById(R.id.MoviesRv)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        lifecycleScope.launch {
            viewModel.getAllMovies()
        }

        viewModel.movies.observe(this, Observer {
            adapter = MovieAdapter(it)
            movieRv.adapter = adapter
            movieRv.layoutManager = GridLayoutManager(this, 3)
        })

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}