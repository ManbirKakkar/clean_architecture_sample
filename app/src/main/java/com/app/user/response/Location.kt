package com.app.user.response

import com.google.gson.annotations.SerializedName

data class Location(

    val city: String,
    @SerializedName("postcode")
    val postcode: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("street")
    val street: String
)