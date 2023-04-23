package com.example.assesmentapplication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assesmentapplication.model.response.MovieInformation
import com.example.assesmentapplication.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val movieList = MutableLiveData<List<MovieInformation>>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    /*fun getNowPlayingMovies() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = movieRepository.fetchNowPlayingMovies(1)
            withContext(Dispatchers.IO) {
                if (response.isSuccessful) {
                    movieList.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error**** : ${response.message()} ")
                }
            }
        }

    }*/

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
           val response = movieRepository.fetchNowPlayingMovies(1)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(
                   { result ->
                       movieList.postValue(result)
                       loading.value = false
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

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}