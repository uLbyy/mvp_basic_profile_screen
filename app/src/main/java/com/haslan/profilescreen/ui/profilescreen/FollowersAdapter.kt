package com.haslan.profilescreen.ui.profilescreen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.haslan.profilescreen.R
import com.haslan.profilescreen.data.model.response.FollowerItem
import kotlinx.android.synthetic.main.item_follower.view.*

class FollowersAdapter : RecyclerView.Adapter<FollowersAdapter.ViewHolder>() {

    private var followers: List<FollowerItem> = emptyList()

    fun setFollowers(followers: List<FollowerItem>) {
        this.followers = followers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_follower, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val follower = followers[position]

        Glide.with(holder.imageFollower.context)
            .load(follower.profilePictureUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.imageFollower)
    }

    override fun getItemCount(): Int {
        return followers.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageFollower = view.image_follower
    }
}
