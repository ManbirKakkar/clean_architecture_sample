package com.app.user.core

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.app.user.core.di.appModule
import com.app.user.core.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class UserApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UserApplication)
            androidLogger()
            modules(provideModules())
        }

    }
    private fun provideModules() = listOf(appModule, networkModule)

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}