package com.wasilyk.app.insulting.mvp.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface InsultsListView : MvpView {
    fun init()
    fun updateInsultsList()
    fun showToast(message: String)
}