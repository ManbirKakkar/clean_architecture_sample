package com.app.user.core.datasources

import com.app.user.core.api.ApiInterface
import com.app.user.core.api.CountryResponse
import com.app.user.core.api.UserResponse

class ApiDataSource(private val apiService: ApiInterface) {

    suspend fun getUsersFromApi(): UserResponse = apiService.getUsers()
    suspend fun getCountriesFromApi(): CountryResponse = apiService.getCountries()
}