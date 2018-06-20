package com.regin.learnbox.home.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.regin.learnbox.home.R
import com.regin.learnbox.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.bottom_navigation as bottomNavigation

class HomeActivity : BaseActivity() {

    override val containerView: View by lazy { container }

    private val navigationController: NavController by lazy {
        findNavController(R.id.navigation_container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        bottomNavigation.setupWithNavController(navigationController)
        setupActionBarWithNavController(navigationController)
    }

    override fun onSupportNavigateUp() = navigationController.navigateUp()
}