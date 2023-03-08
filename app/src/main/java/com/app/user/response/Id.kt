package com.app.user.response

import com.google.gson.annotations.SerializedName

data class Id(

    val name: String,
    @SerializedName("value")
    val value: String
)