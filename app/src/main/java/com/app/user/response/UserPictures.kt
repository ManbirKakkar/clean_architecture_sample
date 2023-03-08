package com.app.user.response

import com.google.gson.annotations.SerializedName

data class UserPictures(
    @SerializedName("large")
    val large: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)