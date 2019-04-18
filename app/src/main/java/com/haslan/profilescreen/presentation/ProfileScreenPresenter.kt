package com.haslan.profilescreen.presentation

import com.haslan.profilescreen.ui.profilescreen.ProfileScreenView

interface ProfileScreenPresenter : BasePresenter<ProfileScreenView> {

    fun getMember()

    fun getFollowers()

    fun getMovies()
}