package com.app.user.core.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "users")
data class UserData(
    @PrimaryKey val id: Int,
    val name: String,
    val firstname: String,
    val email: String,
    val gender: String,
    val location: String,
    val nationality: String,
    val phone: String,
    val picture: String
) : Parcelable
