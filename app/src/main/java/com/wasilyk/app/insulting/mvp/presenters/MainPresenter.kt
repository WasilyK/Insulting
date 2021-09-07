package com.wasilyk.app.insulting.mvp.presenters

import com.github.terrakok.cicerone.Router
import com.wasilyk.app.insulting.mvp.views.MainView
import com.wasilyk.app.insulting.mvp.views.screens.Screens
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val router: Router,
    private val screens: Screens
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(screens.insultsListScreen())
    }

    fun backClicked() = router.exit()
}