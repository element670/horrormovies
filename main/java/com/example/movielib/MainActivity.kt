package com.example.movielib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movielib.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val movieAdapter: MovieAdapter = MovieAdapter()
    private var index = 0;
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding?.apply {
            recycleView.adapter = movieAdapter
            recycleView.layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        }

         binding?.addMovie?.apply {
             setOnClickListener {
                 movieAdapter.addMovie(creaeteMovie(index))
                 index++
             }
         }
    }

    private fun creaeteMovie(index: Int): Movie {
        val res = when (index) {
            0 -> R.drawable.movie2
            1 -> R.drawable.movie3
            else -> R.drawable.movie4
        }
        return Movie(res, "Movie 2")
    }

}