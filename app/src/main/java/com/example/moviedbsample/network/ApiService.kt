package com.example.moviedbsample.network

import com.example.moviedbsample.model.MovieListApiResult
import com.example.moviedbsample.model.videoDetail
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val API_KEY = "b8fb74a7f7ebe3f2402f6de80059d5a5"
private const val BASE_URL_MOVIE="https://www.youtube.com/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

val client = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.*/

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()




interface ApiService {

    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") key: String = API_KEY,
        @Query("page") page: Int = 1
    ): MovieListApiResult

    @GET("movie/{id}")
    suspend fun getMovie(
        @Path("id") id: Int
    )

    @GET("movie/{movie_id}/videos")
    suspend fun getVideo(@Path("movie_id") id: Int ):videoDetail

    //https://api.themoviedb.org/3/search/movie?api_key=b8fb74a7f7ebe3f2402f6de80059d5a5&query=sun
    @GET(" search/movie ")
    suspend fun searchMovie(
        @Query("query") searchKey: String,
        @Query("api_key") key: String = API_KEY,
    ): MovieListApiResult

    @GET("movie/upcoming")
    suspend fun comingSoonMovie(@Query("api_key") key: String = API_KEY): MovieListApiResult

}

//    @GET("p/w500/{poster_path}")
//    suspend fun getPoster(@Path("poster_path") posterPath :String):

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object MoviesApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}
