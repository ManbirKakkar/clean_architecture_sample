package com.app.user.core.api

import com.google.gson.annotations.SerializedName
import com.app.user.response.User
import com.app.user.core.db.UserData

data class UserResponse(
    @SerializedName("results") val results: List<User>
)

fun User.toUser(): UserData {
    return UserData(
        id = dob,
        name = name.last,
        firstname = name.first,
        email = email,
        gender = gender,
        location = location.street + " " + location.city + " " + location.postcode + " " + location.state,
        nationality = nat,
        phone = phone,
        picture = picture.medium,
    )
}