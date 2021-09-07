package com.wasilyk.app.insulting.mvp.views

import com.wasilyk.app.insulting.mvp.models.Insult
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface InsultGenView : MvpView {
    fun setInsult(insult: Insult)
    fun showToast(message: String)
}