package com.example.imdbapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.imdbapp.Model.Movie
import com.example.imdbapp.databinding.MovieItemBinding

class MovieAdapter(private val movieList: List<Movie>): RecyclerView.Adapter<MovieVieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVieHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context))
        return MovieVieHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieVieHolder, position: Int) {
        val data = movieList[position]

        holder.bind(data)
    }
}

class MovieVieHolder(private val binding: MovieItemBinding) : ViewHolder(binding.root){
    fun bind(data: Movie) {
        binding.movieTitle.text = data.title
        binding.releaseYear.text = data.release_date
        Glide.with(binding.root).load(data.poster_path).into(binding.moviePoster)
    }

}