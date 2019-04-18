package com.haslan.profilescreen.data.model.response

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("ItemCount") val itemCount: Int,
    @SerializedName("Items") val movieItems: List<MovieItem>
)