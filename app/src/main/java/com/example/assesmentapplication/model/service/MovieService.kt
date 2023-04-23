package com.example.assesmentapplication.model.service

import com.example.assesmentapplication.model.response.MovieInformation
import io.reactivex.Single
import retrofit2.http.GET

interface MovieService {

    @GET("/3/movie/550?api=")
    suspend fun fetchKeywords(): Single<MovieInformation>
}