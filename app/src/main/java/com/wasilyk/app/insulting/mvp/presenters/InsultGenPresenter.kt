package com.wasilyk.app.insulting.mvp.presenters

import com.github.terrakok.cicerone.Router
import com.wasilyk.app.insulting.mvp.models.Insult
import com.wasilyk.app.insulting.mvp.views.InsultGenView
import com.wasilyk.app.insulting.mvp.views.screens.Screens
import com.wasilyk.app.insulting.repository.local.room.InsultsDao
import com.wasilyk.app.insulting.repository.remote.RemoteDataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class InsultGenPresenter (
    private val router: Router,
    private val screens: Screens,
    private val remoteDataSource: RemoteDataSource,
    private val insultsDao: InsultsDao
) : MvpPresenter<InsultGenView>() {

    private var insult = Insult(-1, "Unknown", "Unknown", -1)
    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadInsult()
    }

    fun loadInsult() {
        compositeDisposable.add(remoteDataSource.getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { insult ->
                    this.insult = insult
                    viewState.setInsult(insult)
                },
                { throwable ->
                    viewState.showToast(throwable.message ?: "Unknown error")
                })
        )
    }

    fun startListGFragment() {
        router.replaceScreen(screens.insultsListScreen())
    }

    fun saveInsult() {
        compositeDisposable.add(insultsDao.insert(insult)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showToast("Saved")
                },
                { throwable ->
                    viewState.showToast(throwable.message ?: "Unknown error")
                }
            ))
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}