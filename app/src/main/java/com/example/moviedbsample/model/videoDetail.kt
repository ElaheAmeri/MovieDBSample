package com.example.moviedbsample.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class videoDetail(
    @Json(name = "id")
    val id: Int,
    @Json(name = "results")
    val results: List<Result>
)