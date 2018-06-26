package com.regin.networking.di

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.regin.networking.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = applicationContext {
    bean {
        HttpLoggingInterceptor()
                .also {
                    it.level = HttpLoggingInterceptor.Level.BODY
                }
    }
    bean { (CoroutineCallAdapterFactory()) }
    bean { (GsonConverterFactory.create(Gson())) }
    bean {
        OkHttpClient().newBuilder()
                .addNetworkInterceptor(get<HttpLoggingInterceptor>())
                .build()
    }
    bean {
        Retrofit.Builder()
                .baseUrl(getProperty<String>("base_url"))
                .addCallAdapterFactory(get<CoroutineCallAdapterFactory>())
                .addConverterFactory(get<GsonConverterFactory>())
                .client(get())
                .build()
                .create(Api::class.java)
    }
}

