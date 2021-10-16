package com.wasilyk.app.insulting.mvp.presenters

import com.wasilyk.app.insulting.mvp.views.ItemView

interface InsultsListAdapterPresenter {
    fun bindView(view: ItemView)
    fun getCount(): Int
}