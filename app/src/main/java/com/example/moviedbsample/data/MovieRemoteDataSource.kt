package com.example.moviedbsample.data

import com.example.moviedbsample.model.Movie
import com.example.moviedbsample.network.MoviesApi

class MovieRemoteDataSource {

    suspend fun getMovies() : List<Movie>{
        try {
            return MoviesApi.retrofitService.getMovies().movieList
        }catch (e : Exception){
            return getSampleMovies()
        }

    }

    suspend fun comingSoon(): List<Movie>{
        try {
            return MoviesApi.retrofitService.comingSoonMovie().movieList
        }catch (e:Exception){
            return getSampleMovies()
        }
    }
    fun getSampleMovies() : List<Movie>{
        return listOf(
            Movie(listOf(), 111,"" , "","supranos" , false),
        )
    }

    suspend fun getVideoKey() : String
    {
        //TODO : return video key
        return ""
    }

     suspend fun searchMovie(searchKey:String) : List<Movie>{
         return MoviesApi.retrofitService.searchMovie(searchKey,).movieList
     }
}