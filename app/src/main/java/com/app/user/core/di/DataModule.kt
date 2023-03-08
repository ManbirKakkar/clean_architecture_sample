package com.app.user.core.di



import com.app.user.BuildConfig
import com.app.user.core.api.ApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private fun provideUsersApi(retrofit: Retrofit): ApiInterface = retrofit.create(
    ApiInterface::class.java
)

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideOkHttpClient(): OkHttpClient {
    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient().newBuilder().addInterceptor(logger).build()
}

val networkModule = module {
    factory { provideUsersApi(get()) }
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}