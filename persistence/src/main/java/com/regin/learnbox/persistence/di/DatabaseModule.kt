package com.regin.learnbox.persistence.di

import android.arch.persistence.room.Room
import com.regin.learnbox.persistence.db.AppDatabase
import org.koin.dsl.module.applicationContext

const val DATABASE_NAME: String = "database.db"

val databaseModule = applicationContext {
    bean {
        Room.databaseBuilder(getProperty("context"), AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
    bean { get<AppDatabase>().taskDao() }
}
