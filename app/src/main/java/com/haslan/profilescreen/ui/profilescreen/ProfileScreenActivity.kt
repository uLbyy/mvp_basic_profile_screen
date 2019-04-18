package com.haslan.profilescreen.ui.profilescreen

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.haslan.profilescreen.R
import com.haslan.profilescreen.data.model.response.Followers
import com.haslan.profilescreen.data.model.response.Member
import com.haslan.profilescreen.data.model.response.Movies
import com.haslan.profilescreen.profileScreenPresenter
import com.haslan.profilescreen.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_profile_screen.*

class ProfileScreenActivity : BaseActivity(), ProfileScreenView {

    private val presenter by lazy { profileScreenPresenter() }

    private lateinit var followersAdapter: FollowersAdapter
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)
        presenter.setView(this)
        setupAdapters()
        presenter.getMember()
        presenter.getFollowers()
        presenter.getMovies()
    }

    override fun onDestroy() {
        presenter.clearPresenterDispose()
        super.onDestroy()
    }

    private fun setupAdapters() {
        followersAdapter = FollowersAdapter()
        with(recycler_followers) {
            layoutManager = LinearLayoutManager(this@ProfileScreenActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = followersAdapter
        }

        moviesAdapter = MoviesAdapter()
        with(recycler_movies) {
            layoutManager = GridLayoutManager(this@ProfileScreenActivity, 3)
            adapter = moviesAdapter
        }
    }

    override fun populateMember(member: Member) {
        text_profile_name.text = member.username

        Glide.with(this)
            .load(member.profilePictureUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(image_profile)

        Glide.with(this)
            .load(member.profileBackgroundPictureUrl)
            .into(image_profile_bg)
    }

    override fun populateFollowers(followers: Followers) {
        followersAdapter.setFollowers(followers.followerItems)
    }

    override fun populateMovies(movies: Movies) {
        moviesAdapter.setMovies(movies.movieItems)
    }
}
