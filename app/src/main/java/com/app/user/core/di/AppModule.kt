package com.app.user.core.di

import android.app.Application
import androidx.room.Room
import com.app.user.core.datasources.ApiDataSource
import com.app.user.core.datasources.DBDataSource
import com.app.user.core.datasources.UserRepo
import com.app.user.core.db.UserDao
import com.app.user.core.db.AppDatabase
import com.app.user.core.db.CountryConverter
import com.app.user.ui.user_list.CountryViewModel
import com.app.user.ui.user_list.UserViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private fun provideDataBase(application: Application): AppDatabase {
    return Room.databaseBuilder(application, AppDatabase::class.java, "userCountry.db")
        .fallbackToDestructiveMigration().addTypeConverter(CountryConverter())
        .build()
}

private fun provideDao(dataBase: AppDatabase): UserDao {
    return dataBase.userDao()
}
val appModule = module {
    single { provideDataBase(androidApplication())}
    single { provideDao(get())}
    single { ApiDataSource(get()) }
    single { DBDataSource(get()) }
    single { UserRepo(get(), get()) }

    viewModel { UserViewModel(get()) }
    viewModel { CountryViewModel(get()) }
}