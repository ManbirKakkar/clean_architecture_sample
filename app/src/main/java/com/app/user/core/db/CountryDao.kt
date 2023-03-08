package com.app.user.core.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(country: List<CountryData>)

    @Query("SELECT * FROM country")
    suspend fun getCountries(): List<CountryData>

    @Query("SELECT * FROM country where region= :region")
    fun getCountriesName(region: String): Flow<List<CountryData>>


    @Query("DELETE FROM country")
    suspend fun deleteAll(): Int
}