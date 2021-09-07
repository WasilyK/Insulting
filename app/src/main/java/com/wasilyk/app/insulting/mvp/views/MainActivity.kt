package com.wasilyk.app.insulting.mvp.views

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.wasilyk.app.insulting.R
import com.wasilyk.app.insulting.app.App
import com.wasilyk.app.insulting.databinding.ActivityMainBinding
import com.wasilyk.app.insulting.mvp.presenters.MainPresenter
import com.wasilyk.app.insulting.mvp.views.screens.Screens
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject lateinit var router: Router
    @Inject lateinit var navigatorHolder: NavigatorHolder
    @Inject lateinit var screens: Screens
    private val navigator = AppNavigator(this, R.id.fragment_container)
    @InjectPresenter lateinit var presenter: MainPresenter
    @ProvidePresenter fun providePresenter(): MainPresenter {
        App.instance.appComponent.inject(this)
        return MainPresenter(router, screens)
    }

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
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