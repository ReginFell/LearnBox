package com.regin.learnbox

import android.app.Application
import com.regin.learnbox.di.appModule
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

        startKoin(this, listOf(appModule))
    }
}