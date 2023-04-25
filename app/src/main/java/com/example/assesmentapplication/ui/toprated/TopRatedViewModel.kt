package com.example.assesmentapplication.ui.toprated

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assesmentapplication.model.response.MovieInformation
import com.example.assesmentapplication.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TopRatedViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val movieList = MutableLiveData<List<MovieInformation>>()
    val loading = MutableLiveData<Boolean>()
    var disposable: Disposable? = null

    init {
        fetchTopRatedMovies()
    }

    private fun fetchTopRatedMovies() {
        disposable = movieRepository.fetchTopRatedMovies(1)
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

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }
}