package com.haslan.profilescreen.data.model.response

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName


data class Result(
    @SerializedName("Result") val result: JsonElement,
    @SerializedName("IsSuccess") val isSuccess: Boolean
   // @SerializedName("Errors") val errors: JsonElement
)
