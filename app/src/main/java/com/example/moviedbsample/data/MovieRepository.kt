package com.example.moviedbsample.data

import com.example.moviedbsample.model.Movie

class MovieRepository(val movieRemoteDataSource : MovieRemoteDataSource ,) {

    suspend fun getMovies() : List<Movie>{
        return movieRemoteDataSource.getMovies()

    }

    suspend fun getYoutubeLink(id : Int) : String {
        return "youtube /watch v = "+ movieRemoteDataSource.getVideoKey()
    }

    suspend fun comingSoon() : List<Movie>{
        return  movieRemoteDataSource.comingSoon()
    }


}