package com.haslan.profilescreen.ui.profilescreen

import com.haslan.profilescreen.data.model.response.Followers
import com.haslan.profilescreen.data.model.response.Member
import com.haslan.profilescreen.data.model.response.Movies

interface ProfileScreenView {

    fun populateMember(member: Member)

    fun populateFollowers(followers: Followers)

    fun populateMovies(movies: Movies)
}