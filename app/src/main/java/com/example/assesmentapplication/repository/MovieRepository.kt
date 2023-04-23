package com.example.assesmentapplication.repository

import com.example.assesmentapplication.model.network.Networking
import com.example.assesmentapplication.model.service.MovieService
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MovieService,
) : Repository {

    suspend fun fetchNowPlayingMovies(page: Int) =
        movieService.fetchNowPlayingMovies(page, Networking.API_KEY)

    suspend fun fetchTopRatedMovies(page: Int) =
        movieService.fetchTopRatedMovies(page, Networking.API_KEY)

    suspend fun fetchPopularMovies(page: Int) =
        movieService.fetchPopularMovies(page, Networking.API_KEY)

    suspend fun fetchUpcomingMovies(page: Int) =
        movieService.fetchUpcomingMovies(page, Networking.API_KEY)
}
