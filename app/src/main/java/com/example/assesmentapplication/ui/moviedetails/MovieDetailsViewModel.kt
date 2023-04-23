package com.example.assesmentapplication.ui.moviedetails

import androidx.lifecycle.ViewModel
import com.example.assesmentapplication.repository.MovieRepository
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

}