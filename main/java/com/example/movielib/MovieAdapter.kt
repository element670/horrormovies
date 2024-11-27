package com.example.movielib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.movielib.databinding.MovieItemBinding

class MovieAdapter(data: MutableList<Movie> = mutableListOf()) : RecyclerView.Adapter<MovieHolder>() {

    private var movies: MutableList<Movie> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun addMovie(movie: Movie) {
        movies.add(movie)
        notifyDataSetChanged()
    }

    fun addMovies(movie: ArrayList<Movie>) {
        movies.addAll(movie)
        notifyDataSetChanged()
    }


}

class MovieHolder(view: View) : ViewHolder(view) {
    val binding = MovieItemBinding.bind(view)

    fun bind(movie: Movie) = with(binding) {
        imageView.setImageResource(movie.resId)
        title.text = movie.title
    }


}