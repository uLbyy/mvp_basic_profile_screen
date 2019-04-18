package com.haslan.profilescreen.data.model.response

import com.google.gson.annotations.SerializedName

data class Member(
    @SerializedName("userId") val userId: String,
    @SerializedName("username") val username: String,
    @SerializedName("profilePictureUrl") val profilePictureUrl: String,
    @SerializedName("profileBackgroundPictureUrl") val profileBackgroundPictureUrl: String
)