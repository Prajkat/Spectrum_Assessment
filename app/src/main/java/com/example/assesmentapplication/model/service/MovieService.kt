package com.example.assesmentapplication.model.service

import com.example.assesmentapplication.model.response.nowplaying.MovieResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface MovieService {

    @GET("/3/movie/now_playing")
    fun fetchNowPlayingMovies(@Query("page") page: Int): Observable<MovieResponse>

    @GET("/3/movie/popular")
    fun fetchPopularMovies(@Query("page") page: Int): Observable<MovieResponse>

    @GET("/3/movie/top_rated")
    fun fetchTopRatedMovies(@Query("page") page: Int): Observable<MovieResponse>

    @GET("/3/movie/upcoming")
    fun fetchUpcomingMovies(@Query("page") page: Int): Observable<MovieResponse>
}