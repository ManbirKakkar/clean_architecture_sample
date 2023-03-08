package com.app.user.core.datasources

import com.app.user.core.db.CountryData
import com.app.user.core.db.UserData

class UserRepo(
    private val apiDataSource: ApiDataSource,
    private val dbDataSource: DBDataSource
) {

    suspend fun getApiUsers() = apiDataSource.getUsersFromApi()

    fun getUsersFromLocal() = dbDataSource.getUsersFromDB()

    suspend fun insertAllUsers(users: List<UserData>) = dbDataSource.insertUsers(users)

    suspend fun getCountries() = apiDataSource.getCountriesFromApi()

    suspend fun getCountryFromLocal() = dbDataSource.getCountriesFromDB()

    suspend fun insertCountries(country: List<CountryData>) = dbDataSource.insertCountry(country)

    suspend fun deleteAll() = dbDataSource.deleteAll()
}
