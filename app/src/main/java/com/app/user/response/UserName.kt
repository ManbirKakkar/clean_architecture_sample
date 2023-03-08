package com.app.user.response

import com.google.gson.annotations.SerializedName

data class UserName(
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String,
    @SerializedName("title")
    val title: String
)