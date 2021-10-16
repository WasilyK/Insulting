package com.wasilyk.app.insulting.mvp.views

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.wasilyk.app.insulting.R
import com.wasilyk.app.insulting.databinding.ActivityMainBinding
import com.wasilyk.app.insulting.mvp.views.screens.Screens
import javax.inject.Inject

class MainActivity : MoxyDaggerBaseActivity() {

    @Inject lateinit var router: Router
    @Inject lateinit var navigatorHolder: NavigatorHolder
    @Inject lateinit var screens: Screens
    private val navigator = AppNavigator(this, R.id.fragment_container)

    private var viewBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)
        router.newRootScreen(screens.insultsListScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}