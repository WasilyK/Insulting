package com.wasilyk.app.insulting.di.factories

import com.wasilyk.app.insulting.mvp.presenters.InsultsListPresenter
import dagger.assisted.AssistedFactory

@AssistedFactory
interface InsultsListPresenterFactory {
    fun create(): InsultsListPresenter
}