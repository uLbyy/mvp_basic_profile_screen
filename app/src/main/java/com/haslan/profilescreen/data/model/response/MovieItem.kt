package com.haslan.profilescreen.data.model.response

import com.google.gson.annotations.SerializedName

data class MovieItem(
    @SerializedName("Id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("profilePictureUrl") val profilePictureUrl: String,
    @SerializedName("isLiked") val isLiked: Boolean,
    @SerializedName("likeCount") val likeCount: Int,
    @SerializedName("createDate") val createDate: String
)
