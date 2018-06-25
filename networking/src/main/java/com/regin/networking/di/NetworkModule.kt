package com.regin.networking.di

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.regin.networking.api.Api
import okhttp3.OkHttpClient
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = applicationContext {
    bean { (CoroutineCallAdapterFactory()) }
    bean { (GsonConverterFactory.create(Gson())) }
    bean { OkHttpClient().newBuilder().build() }
    bean {
        Retrofit.Builder()
                .baseUrl(getProperty<String>("BASE_URL"))
                .addCallAdapterFactory(get<CoroutineCallAdapterFactory>())
                .addConverterFactory(get<GsonConverterFactory>())
                .client(get())
                .build()
                .create(Api::class.java)
    }
}

