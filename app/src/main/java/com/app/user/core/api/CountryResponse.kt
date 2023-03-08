package com.app.user.core.api


import com.app.user.core.db.CountryData
import com.app.user.response.CountryKeys
import com.app.user.response.CountryValues
import com.google.gson.annotations.SerializedName

data class CountryResponse(@SerializedName("data")
                           val data: Map<String, CountryValues>)
/*
fun CountryKeys.toCountry(): CountryData {
    return CountryData(
        countryCode =code,
                countryName=country, region=region
    )
}*/
