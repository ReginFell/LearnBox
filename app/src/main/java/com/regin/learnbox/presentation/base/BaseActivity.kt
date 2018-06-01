package com.regin.learnbox.presentation.base

import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.regin.learnbox.Application
import com.regin.learnbox.presentation.navigation.navigateTo
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

abstract class BaseActivity : AppCompatActivity() {

    override fun onResumeFragments() {
        super.onResumeFragments()
        Application.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        Application.getNavigatorHolder().removeNavigator()
    }

    private val navigator = object : Navigator {

        override fun applyCommands(commands: Array<out Command>) {
            commands.forEach { applyCommand(it) }
        }

        private fun applyCommand(command: Command) {
            if (command is Forward) {
                forward(command)
            } else {
                Log.d("Cicerone", "unknown navigation")
            }
        }

        private fun forward(command: Forward) {
            navigateTo(this@BaseActivity, command.screenKey)
        }
    }
}