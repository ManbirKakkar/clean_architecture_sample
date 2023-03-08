package com.app.user.core.datasources

import com.app.user.core.db.AppDatabase
import com.app.user.core.db.CountryData
import com.app.user.core.db.UserData
import kotlinx.coroutines.flow.Flow

class DBDataSource(private val database: AppDatabase) {

    fun getUsersFromDB(): Flow<List<UserData>> = database.userDao().getUsers()

    suspend fun insertUsers(users: List<UserData>) = database.userDao().insertAll(users)

    suspend fun getCountriesFromDB():List<CountryData> = database.countryDao().getCountries()

    suspend fun insertCountry(country: List<CountryData>) = database.countryDao().insertCountry(country)

    suspend fun deleteAll() = database.countryDao().deleteAll()

}