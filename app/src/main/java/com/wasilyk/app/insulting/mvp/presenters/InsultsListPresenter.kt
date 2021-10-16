package com.wasilyk.app.insulting.mvp.presenters

import com.github.terrakok.cicerone.Router
import com.wasilyk.app.insulting.mvp.models.Insult
import com.wasilyk.app.insulting.mvp.views.InsultsListView
import com.wasilyk.app.insulting.mvp.views.ItemView
import com.wasilyk.app.insulting.mvp.views.screens.Screens
import com.wasilyk.app.insulting.repository.local.LocalDataSource
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class InsultsListPresenter @AssistedInject constructor(
    private val localDataSource: LocalDataSource,
    private val router: Router,
    private val screens: Screens
) : MvpPresenter<InsultsListView>() {

    val adapterPresenter = InsultsListAdapterPresenterImpl()
    private val insults = mutableListOf<Insult>()
    private val disposables: CompositeDisposable = CompositeDisposable()

    inner class InsultsListAdapterPresenterImpl() :
        InsultsListAdapterPresenter {

        override fun bindView(view: ItemView) =
            view.setInsults(insults[view.pos])

        override fun getCount() = insults.size
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {
        disposables.add(localDataSource
            .getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { insults ->
                    this.insults.addAll(insults)
                    viewState.updateInsultsList()
                },
                { throwable ->
                    viewState.showToast(throwable.message ?: "Unknown error")
                }
            )
        )
    }

    fun startGenFragment() {
        router.replaceScreen(screens.insultGenScreen())
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}