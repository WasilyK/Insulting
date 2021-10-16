package com.wasilyk.app.insulting.mvp.views

import com.wasilyk.app.insulting.mvp.models.Insult

interface ItemView {
    var pos: Int
    fun setInsults(insult: Insult)
}