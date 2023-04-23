package com.example.assesmentapplication.model.service

import com.example.assesmentapplication.model.response.MovieInformation
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/3/movie/now_playing?")
    suspend fun fetchNowPlayingMovies(
        @Query("page") page: Int,
        @Query("api-key") apikey: String
    ): Observable<List<MovieInformation>>

    @GET("/3/movie/popular?")
    suspend fun fetchPopularMovies(
        @Query("page") page: Int,
        @Query("api-key") apikey: String
    ): Response<List<MovieInformation>>

    @GET("/3/movie/top_rated?")
    suspend fun fetchTopRatedMovies(
        @Query("page") page: Int,
        @Query("api-key") apikey: String
    ): Response<List<MovieInformation>>

    @GET("/3/movie/upcoming?")
    suspend fun fetchUpcomingMovies(
        @Query("page") page: Int,
        @Query("api-key") apikey: String
    ): Response<List<MovieInformation>>
}