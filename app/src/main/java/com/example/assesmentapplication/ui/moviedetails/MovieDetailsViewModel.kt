package com.example.assesmentapplication.ui.moviedetails

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assesmentapplication.model.response.moviedetails.MovieDetails
import com.example.assesmentapplication.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val movieDetails = MutableLiveData<MovieDetails>()
    val loading = MutableLiveData<Boolean>()
    var disposable: Disposable? = null

    fun fetchMovieDetails(movieID: Int?) {
        disposable = movieID?.let {
            movieRepository.fetchMovieDetails(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        movieDetails.postValue(result)
                        loading.value = false
                        Log.d("Movie Details", result.title)
                    },
                    {
                        onError("Error**** : ${it.message} ")
                    })
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }
}