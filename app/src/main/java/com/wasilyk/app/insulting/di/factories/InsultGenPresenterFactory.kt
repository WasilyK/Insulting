package com.wasilyk.app.insulting.di.factories

import com.wasilyk.app.insulting.mvp.presenters.InsultGenPresenter
import dagger.assisted.AssistedFactory

@AssistedFactory
interface InsultGenPresenterFactory {
    fun create(): InsultGenPresenter
}