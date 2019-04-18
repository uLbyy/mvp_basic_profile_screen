package com.haslan.profilescreen.presentation.implementation

import com.google.gson.Gson
import com.haslan.profilescreen.common.clearPresenterDispose
import com.haslan.profilescreen.data.api.ApiManager
import com.haslan.profilescreen.data.api.ApiSubscriber
import com.haslan.profilescreen.data.model.response.Followers
import com.haslan.profilescreen.data.model.response.Member
import com.haslan.profilescreen.data.model.response.Movies
import com.haslan.profilescreen.data.model.response.Result
import com.haslan.profilescreen.presentation.ProfileScreenPresenter
import com.haslan.profilescreen.ui.profilescreen.ProfileScreenView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProfileScreenPresenterImpl @Inject constructor(
    private val apiManager: ApiManager
) : ProfileScreenPresenter {

    private lateinit var view: ProfileScreenView

    private val disposableMember = CompositeDisposable()
    private val disposableFollowers = CompositeDisposable()
    private val disposableMovies = CompositeDisposable()

    override fun setView(view: ProfileScreenView) {
        this.view = view
    }

    override fun getMember() {
        val apiSubscriber = object : ApiSubscriber<Result>() {
            override fun success(t: Result) {
                val member = Gson().fromJson<Member>(t.result, Member::class.java)
                view.populateMember(member)
            }
        }
        disposableMember.add(apiManager.getMember().subscribeWith(apiSubscriber))
    }

    override fun getFollowers() {
        val apiSubscriber = object : ApiSubscriber<Result>() {
            override fun success(t: Result) {
                val followers = Gson().fromJson<Followers>(t.result, Followers::class.java)
                view.populateFollowers(followers)
            }
        }
        disposableFollowers.add(apiManager.getFollowers().subscribeWith(apiSubscriber))
    }

    override fun getMovies() {
        val apiSubscriber = object : ApiSubscriber<Result>() {
            override fun success(t: Result) {
                val movies: Movies = Gson().fromJson<Movies>(t.result, Movies::class.java)
                view.populateMovies(movies)
            }
        }
        disposableMovies.add(apiManager.getMovies().subscribeWith(apiSubscriber))
    }

    override fun clearPresenterDispose() {
        clearPresenterDispose(disposableMember)
        clearPresenterDispose(disposableFollowers)
        clearPresenterDispose(disposableMovies)
    }
}