package com.regin.learnbox.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import androidx.navigation.Navigation
import com.regin.learnbox.Application
import com.regin.learnbox.R
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
    }

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
            Navigation.findNavController(this@NavigationActivity, R.id.nav_host_fragment).navigate(R.id.action_splash_screen_to_home_screen)
        }
    }
}