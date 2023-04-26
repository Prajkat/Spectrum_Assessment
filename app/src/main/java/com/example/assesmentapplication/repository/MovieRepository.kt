package com.example.assesmentapplication.repository

import com.example.assesmentapplication.model.response.nowplaying.MovieResponse
import com.example.assesmentapplication.model.service.MovieService
import io.reactivex.Observable
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MovieService,
) : Repository {

    fun fetchNowPlayingMovies(page: Int): Observable<MovieResponse> =
        movieService.fetchNowPlayingMovies(page)

    fun fetchTopRatedMovies(page: Int): Observable<MovieResponse> =
        movieService.fetchTopRatedMovies(page)

    fun fetchPopularMovies(page: Int): Observable<MovieResponse> =
        movieService.fetchPopularMovies(page)

    fun fetchUpcomingMovies(page: Int): Observable<MovieResponse> =
        movieService.fetchUpcomingMovies(page)
}
