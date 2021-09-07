package com.wasilyk.app.insulting.mvp.views.screens

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.wasilyk.app.insulting.mvp.views.InsultGenFragment
import com.wasilyk.app.insulting.mvp.views.InsultsListFragment

class ScreensImpl : Screens {

    override fun insultsListScreen(): Screen = FragmentScreen {
        InsultsListFragment.newInstance()
    }

    override fun insultGenScreen(): Screen = FragmentScreen {
        InsultGenFragment.newInstance()
    }
}