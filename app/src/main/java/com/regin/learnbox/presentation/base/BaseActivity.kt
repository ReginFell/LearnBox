package com.regin.learnbox.presentation.base

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.regin.learnbox.Application
import com.regin.learnbox.R
import com.regin.learnbox.models.core.Error
import com.regin.learnbox.presentation.navigation.navigateTo
import com.regin.learnbox.presentation.view.MaterialSnackbar
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

abstract class BaseActivity : AppCompatActivity() {

    abstract val containerView: View

    override fun onResumeFragments() {
        super.onResumeFragments()
        Application.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        Application.getNavigatorHolder().removeNavigator()
    }

    fun handleError(error: Error) {
        MaterialSnackbar.make(containerView, error.throwable.message.toString(), Snackbar.LENGTH_LONG)
                .also {
                    error.retry?.run {
                        it.setAction(R.string.retry) { this() }
                    }
                }
                .show()
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