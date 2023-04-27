package com.example.assesmentapplication.ui.moviedetails

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.assesmentapplication.MainApplication
import com.example.assesmentapplication.databinding.ActivityMovieDetailsBinding
import com.example.assesmentapplication.di.component.DaggerActivityComponent
import com.example.assesmentapplication.di.module.ActivityModule
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    @Inject
    lateinit var viewModel: MovieDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()

        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting the bundle back from the android
        val bundle = intent.extras

        // getting the string back
        val movieID = bundle?.getInt("movieID")

        viewModel.fetchMovieDetails(movieID)
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.movieDetails.observe(this, Observer {
            binding.movieDetails = it
            loadImage("https://image.tmdb.org/t/p/original${it.poster_path}")
        })

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, "No Movie Details Found", Toast.LENGTH_SHORT).show()
        })
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent
            .builder()
            .applicationComponent((application as MainApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
        activityComponent.inject(this)
    }

    private fun loadImage(url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(this).load(url)
                .into(binding.moviePosterImageView)
        }
    }
}