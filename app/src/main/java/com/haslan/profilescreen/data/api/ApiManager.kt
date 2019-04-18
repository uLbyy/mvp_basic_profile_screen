package com.haslan.profilescreen.data.api

import com.haslan.profilescreen.data.model.response.Result
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiManager(private val apiService: ApiService) {

    fun getMember(): Flowable<Result> =
        apiService
            .getMember()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getFollowers(): Flowable<Result> =
        apiService
            .getFollowers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getMovies(): Flowable<Result> =
        apiService
            .getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}