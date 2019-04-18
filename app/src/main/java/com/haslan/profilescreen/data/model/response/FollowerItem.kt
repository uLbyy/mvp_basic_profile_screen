package com.haslan.profilescreen.data.model.response

import com.google.gson.annotations.SerializedName

data class FollowerItem(
    @SerializedName("userId") val userId: String,
    @SerializedName("profilePictureUrl") val profilePictureUrl: String
)