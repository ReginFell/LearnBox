package com.regin.learnbox

import android.app.Application
import com.regin.learnbox.di.appModule
import com.regin.networking.di.networkModule
import org.koin.android.ext.android.startKoin
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class Application : Application() {

    companion object {
        private var cicerone: Cicerone<Router> = Cicerone.create()

        fun getNavigatorHolder(): NavigatorHolder {
            return cicerone.navigatorHolder
        }

        fun getRouter(): Router {
            return cicerone.router
        }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule, networkModule), mapOf(Pair("BASE_URL", BuildConfig.API)))
    }
}