package com.wasilyk.app.insulting.mvp.presenters

import com.github.terrakok.cicerone.Router
import com.wasilyk.app.insulting.mvp.models.Insult
import com.wasilyk.app.insulting.mvp.views.InsultsListView
import com.wasilyk.app.insulting.mvp.views.ItemView
import com.wasilyk.app.insulting.mvp.views.screens.Screens
import com.wasilyk.app.insulting.repository.local.LocalDataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class InsultsListPresenter @Inject constructor() :
    MvpPresenter<InsultsListView>() {

    @Inject
    lateinit var localDataSource: LocalDataSource
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screens: Screens
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