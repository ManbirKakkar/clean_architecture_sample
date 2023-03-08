package com.app.user.response

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("cell")
    val cell: String,
    @SerializedName("dob")
    val dob: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Id,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: UserName,
    @SerializedName("nat")
    val nat: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("picture")
    val picture: UserPictures,
    @SerializedName("registered")
    val registered: String
)