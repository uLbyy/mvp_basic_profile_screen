package com.haslan.profilescreen.data.api

import com.haslan.profilescreen.data.model.response.Result
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("member")
    fun getMember(): Flowable<Result>

    @GET("Followers")
    fun getFollowers(): Flowable<Result>

    @GET("movies")
    fun getMovies(): Flowable<Result>
}