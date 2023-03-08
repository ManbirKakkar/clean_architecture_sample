package com.app.user.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [UserData::class, CountryData::class], version = 1, exportSchema = false)
@TypeConverters(CountryConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun countryDao(): CountryDao

}