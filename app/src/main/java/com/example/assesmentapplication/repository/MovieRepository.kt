package com.example.assesmentapplication.repository

import com.example.assesmentapplication.model.response.MovieInformation
import com.example.assesmentapplication.model.service.MovieService
import io.reactivex.Observable
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MovieService,
) : Repository {

    fun fetchNowPlayingMovies(page: Int): Observable<List<MovieInformation>> =
        movieService.fetchNowPlayingMovies(page)

    fun fetchTopRatedMovies(page: Int): Observable<List<MovieInformation>> =
        movieService.fetchTopRatedMovies(page)

    fun fetchPopularMovies(page: Int): Observable<List<MovieInformation>> =
        movieService.fetchPopularMovies(page)

    fun fetchUpcomingMovies(page: Int): Observable<List<MovieInformation>> =
        movieService.fetchUpcomingMovies(page)
}
