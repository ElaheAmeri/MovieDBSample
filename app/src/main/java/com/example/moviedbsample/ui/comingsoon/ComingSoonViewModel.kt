package com.example.moviedbsample.ui.comingsoon

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbsample.domain.Container
import com.example.moviedbsample.model.Movie
import com.example.moviedbsample.ui.movielist.ApiStatus
import kotlinx.coroutines.launch

class ComingSoonViewModel : ViewModel(){

    val status = MutableLiveData<ApiStatus>()
    val movieList = MutableLiveData<List<Movie>>()

    init{
        getComingSoonMovies()
    }
    fun getComingSoonMovies() {
        status.value = ApiStatus.LOADING
        viewModelScope.launch {

            val list = Container.movieRepository.comingSoon()
            movieList.value = list
            status.value = ApiStatus.DONE
            Log.d("tag" , list[0].posterPath)
        }
    }
}