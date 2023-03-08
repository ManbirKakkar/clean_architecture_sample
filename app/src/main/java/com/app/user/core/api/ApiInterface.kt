package com.app.user.core.api

import retrofit2.http.GET

interface ApiInterface {
    @GET("api/1.0/?results=100")
    suspend fun getUsers(): UserResponse

    @GET("data/v1/countries")
    suspend fun getCountries(): CountryResponse
}