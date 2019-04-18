package com.haslan.profilescreen.data.model.response

import com.google.gson.annotations.SerializedName

data class Followers(
    @SerializedName("ItemCount") val itemCount: Int,
    @SerializedName("Items") val followerItems: List<FollowerItem>
)