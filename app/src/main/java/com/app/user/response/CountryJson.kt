package com.app.user.response

import android.os.Parcelable
import androidx.room.TypeConverters
import com.app.user.core.db.CountryConverter
import kotlinx.android.parcel.Parcelize

@TypeConverters(CountryConverter::class)
@Parcelize
data class CountryJson(val  countryName: String, val countryCode: String): Parcelable
