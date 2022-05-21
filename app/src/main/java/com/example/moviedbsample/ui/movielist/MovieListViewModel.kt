package com.example.moviedbsample.ui.movielist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbsample.domain.Container
import com.example.moviedbsample.model.Movie
import kotlinx.coroutines.launch


enum class ApiStatus { LOADING, DONE, ERROR }

class MovieListViewModel : ViewModel() {
    val status = MutableLiveData<ApiStatus>()
    val movieList = MutableLiveData<List<Movie>>()

    init{
        getMovies()
    }
    fun getMovies() {
        status.value = ApiStatus.LOADING
        viewModelScope.launch {

            val list = Container.movieRepository.getMovies()

            movieList.value = list
            status.value = ApiStatus.DONE
            Log.d("tag" , list[0].posterPath)
        }
    }

}